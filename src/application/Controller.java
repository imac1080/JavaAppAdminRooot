package application;

import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {
	// private String user = "Sergio";
	// private String password = "123456";
	private JSONObject user, newUser;
	private JSONArray events;
	private ArrayList<String> userFields = new ArrayList<String>();
	private ArrayList<Pane> pane = new ArrayList<>();
	private ArrayList<MenuItem> menuItems = new ArrayList<>();
	private int delay = 3000; // milliseconds
	@FXML
	private DatePicker userBirthday;
	@FXML
	private AnchorPane mainPane;
	@FXML
	private MenuItem menuUsuarios, menuEventos, menuConfig;
	@FXML
	private TextField loginUser, userName, userSurname1, userSurname2, userDNI, userEmail, userEmailConfirm,
			userPhoneNumber, userAddress, userCP, userLanguage, userPassw, userPasswConfirm;
	@FXML
	private PasswordField loginPassw, userCreatePassw, userCreatePass2;
	@FXML
	private Pane paneAdduser, paneLogin, paneMain, paneCreateAcc, paneUser, paneUserList, paneEventCreate, paneEventList;
	@FXML
	private Button loginEnter, createUserInfo, createUser, loginBtnPasswError, singUpButton,showEvents, createEventInfo;
	@FXML
	private DialogPane loginPasswError;
	@FXML
	private ComboBox<String> crearComboCiudad, eventComboPartida, eventComboLlegada, eventComboValidez;
	@FXML
	private Label errorLogin;
	@FXML
	private ImageView ivProblemas, ivUser, ivPassword, ivLoginLogo, ivMainLogo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pane.add(paneLogin);
		pane.add(paneAdduser);
		pane.add(paneMain);
		pane.add(paneCreateAcc);
		pane.add(paneUser);
		pane.add(paneUserList);
		pane.add(paneEventCreate);
		pane.add(paneEventList);

		menuItems.add(menuConfig);
		menuItems.add(menuUsuarios);
		menuItems.add(menuEventos);

		ivProblemas.setImage(new Image("/Imagenes/LoginError.jpg"));
		ivUser.setImage(new Image("/Imagenes/LoginUser.png"));
		ivPassword.setImage(new Image("/Imagenes/LoginPassword.png"));
		ivLoginLogo.setImage(new Image("/Imagenes/LoginLogoInter.png"));
		ivMainLogo.setImage(new Image("/Imagenes/MainLogo.jpg"));
		ObservableList<String> itemsProvincias = FXCollections.observableArrayList();
		itemsProvincias.addAll("Alava", "Albacete", "Alicante", "Almería", "Asturias", "Avila", "Badajoz", "Barcelona", "Burgos",
				"Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña", "Cuenca", "Gerona",
				"Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "León", "Lérida",
				"Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Las Palmas", "Pontevedra",
				"La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Santa Cruz de Tenerife", "Teruel",
				"Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza");
		crearComboCiudad.setItems(itemsProvincias);
		eventComboPartida.setItems(itemsProvincias);
		eventComboLlegada.setItems(itemsProvincias);
		ObservableList<String> itemsValidez = FXCollections.observableArrayList();
		itemsValidez.addAll("True", "False");
		eventComboValidez.setItems(itemsValidez);

	}

	@FXML
	private void menuLogin(ActionEvent event) throws InterruptedException { // Login
		String email = loginUser.getText();
		String passwrd = loginPassw.getText();

		Button btn = (Button) event.getSource();
		btn.getOnAction();
		ActionListener taskPerformer = new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				errorLogin.setVisible(false);
			}
		};
		ActionListener taskPerformer1 = new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				paneMain.setVisible(false);
				paneUser.setVisible(true);
			}
		};
		try {
			user = Conexion.Post_JSON_Login(email, passwrd);
		} catch (Exception e) {
			System.out.println("Auth fallida");
		}
		if (user != null) {
			loginPassw.clear();
			loginUser.clear();
			paneLogin.setVisible(false);
			itemsTrue();
			paneMain.setVisible(true);
			javax.swing.Timer tick1 = new javax.swing.Timer(delay, taskPerformer1);
			tick1.setRepeats(false);
			tick1.start();
		} else {
			errorLogin.setText("Credenciales incorrectos");
			errorLogin.setVisible(true);
			javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
			tick.setRepeats(false);
			tick.start();
			loginPassw.clear();
			loginUser.clear();
		}

		/*
		 * if (loginUser.getText().equals(user)) { if
		 * (loginPassw.getText().equals(password)) { // Quitamos el login y poenos los
		 * menu items y la pagina // inicial. loginPassw.clear(); loginUser.clear();
		 * paneLogin.setVisible(false); itemsTrue(); paneMain.setVisible(true); } else {
		 * errorLogin.setText("La contraseña es incorrecta");
		 * errorLogin.setVisible(true); javax.swing.Timer tick = new
		 * javax.swing.Timer(delay, taskPerformer); tick.setRepeats(false);
		 * tick.start();
		 * 
		 * loginPassw.clear(); loginUser.clear(); } } else {
		 * errorLogin.setText("El usuario es incorrecto"); errorLogin.setVisible(true);
		 * javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
		 * tick.setRepeats(false); tick.start(); loginPassw.clear(); loginUser.clear();
		 * }
		 */
	}

	@FXML
	private void actionMenu(ActionEvent event) {
		paneFalse(); // Ponemos el resto de panels en invisible.
		MenuItem menuClicked = (MenuItem) event.getSource(); // Click menu items.
		switch (menuClicked.getId()) {
		case "userCreate":
			paneAdduser.setVisible(true);
			break;
		case "userClose":
			paneLogin.setVisible(true);
			itemsFalse();
			Conexion.Post_JSON_LogOutAll(user);
			user = null;
			break;
		case "userList":
			paneUserList.setVisible(true);
			break;
		case "eventCreate":
			paneEventCreate.setVisible(true);
			break;
		case "eventList":
			paneEventList.setVisible(true);
			break;
		default:
			break;
		}
	}

	public void createNewUser() {
		try {
			if (userEmail.getText().equals(userEmailConfirm.getText())
					&& userPassw.getText().equals(userPasswConfirm.getText())) {
				if (userPassw.getLength() < 8) {
					System.out.println("contraseña tiene k ser mayor a 8 caracteres");
				} else {
					userFields.add(userName.getText());
					userFields.add(userSurname1.getText() + " " + userSurname2.getText());
					userFields.add(userEmail.getText());
					userFields.add(userPassw.getText());
					userFields.add(crearComboCiudad.getValue());
					userFields.add(userAddress.getText());
					userFields.add(userCP.getText());
					userFields.add(userDNI.getText());
					LocalDate localDate = userBirthday.getValue();
					Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
					String strDate = dateFormat.format(date);
					userFields.add(strDate);
					userFields.add(userPhoneNumber.getText());
					userFields.add(userLanguage.getText());
				}
			} else {
				// aki lo suyo seria poner un label k se muestre x 3 sec
				// como tenemos en el login principal
				System.out.println("el email no coincide");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("datos introducidos con errores, no se pueden recoger");
		}
	}
	@FXML
	private void eventButton(ActionEvent event) {
		Button btn = (Button) event.getSource();
		btn.getOnAction();
		paneFalse();
		switch (btn.getId()) {
		case "showEvents":
			Conexion.Get_JSON_AllEvents(user);
			break;
		}
	}

	@FXML
	private void createUsers(ActionEvent event) {
		Button btn = (Button) event.getSource();
		btn.getOnAction();
		paneFalse();
		switch (btn.getId()) {
		case "createUserInfo":
			createNewUser();
			if (userFields.size() == Conexion.userFields.length) {

				newUser = Conexion.Post_JSON_User_Create(userFields);
				if (newUser != null) {
					paneCreateAcc.setVisible(true);
				} else {
					// tambien label con timer aki need
					System.out.println("Error creando el user, la conexion con mongodb o api no ha funcionado");
					paneAdduser.setVisible(true);
				}
			} else {
				// tambien label con timer aki need
				System.out.println("Error creando el user, no has rellenado los campos correctamente");
				paneAdduser.setVisible(true);
			}

			break;
		case "createUser":
			paneLogin.setVisible(true);
			break;
		case "singUpButton":
			paneAdduser.setVisible(true);
			break;
		}
	}
	
	@FXML
	private void createEvent(ActionEvent event) {
		Button btn = (Button) event.getSource();
		btn.getOnAction();
		paneFalse();
		switch (btn.getId()) {
		case "createEventInfo":
			paneMain.setVisible(true);
			/*
			createNewUser();
			if (userFields.size() == Conexion.userFields.length) {

				newUser = Conexion.Post_JSON_User_Create(userFields);
				if (newUser != null) {
					paneCreateAcc.setVisible(true);
				} else {
					// tambien label con timer aki need
					System.out.println("Error creando el user, la conexion con mongodb o api no ha funcionado");
					paneAdduser.setVisible(true);
				}
			} else {
				// tambien label con timer aki need
				System.out.println("Error creando el user, no has rellenado los campos correctamente");
				paneAdduser.setVisible(true);
			}

			break;
		case "createUser":
			paneLogin.setVisible(true);
			break;
		case "singUpButton":
			paneAdduser.setVisible(true);
			*/
			break;
		}
	}

	public void itemsFalse() {
		for (int j = 0; j < menuItems.size(); j++) {
			menuItems.get(j).setVisible(false);
		}
	}

	public void itemsTrue() {
		for (int j = 0; j < menuItems.size(); j++) {
			menuItems.get(j).setVisible(true);
		}
	}

	public void paneFalse() {
		for (int i = 0; i < pane.size(); i++) {
			pane.get(i).setVisible(false);
		}
	}
}
