package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {
	private String user = "Sergio";
	private String password = "123456";
	private ArrayList<Pane> pane = new ArrayList<>();
	private ArrayList<MenuItem> menuItems = new ArrayList<>();

	@FXML
	private AnchorPane mainPane;
	@FXML
	private MenuItem menuUsuarios, menuEventos, menuConfig;
	@FXML
	private TextField loginUser, userCreateName, userCreateSurname, userCreateDni, userCreateEmail;
	@FXML
	private PasswordField loginPassw, userCreatePassw, userCreatePass2;
	@FXML
	private Pane paneAdduser, paneLogin, paneMain, paneCreateAcc;
	@FXML
	private Button loginEnter, createUserInfo, createUser, loginBtnPasswError;
	@FXML
	private DialogPane loginPasswError;
	@FXML
	private ComboBox<String> crearComboCiudad;
	@FXML
	private Label errorLogin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pane.add(paneLogin);
		pane.add(paneAdduser);
		pane.add(paneMain);
		pane.add(paneCreateAcc);

		menuItems.add(menuConfig);
		menuItems.add(menuUsuarios);
		menuItems.add(menuEventos);

		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Alava", "Albacete", "Alicante", "Almería", "Asturias", "Avila", "Badajoz", "Barcelona", "Burgos",
				"Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña", "Cuenca", "Gerona",
				"Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "León", "Lérida",
				"Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Las Palmas", "Pontevedra",
				"La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Santa Cruz de Tenerife", "Teruel",
				"Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza");
		crearComboCiudad.setItems(items);
	}

	@FXML
	private void menuLogin(ActionEvent event) throws InterruptedException { // Login
		Button btn = (Button) event.getSource();
		btn.getOnAction();
		if (loginUser.getText().equals(user)) {
			if (loginPassw.getText().equals(password)) { // Quitamos el login y poenos los menu items y la pagina
															// inicial.
				loginPassw.clear();
				loginUser.clear();
				paneLogin.setVisible(false);
				itemsTrue();
				paneMain.setVisible(true);
			} else {
				/*
				System.out.println("Hola");
				errorLogin.setVisible(true);
				Thread.sleep(2000);
				*/
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Password incorrecto");
				alert.showAndWait();
				loginPassw.clear();
				loginUser.clear();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Datos de usuario incorrectos");
			alert.showAndWait();
			loginPassw.clear();
			loginUser.clear();
		}
		

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
			break;
		default:
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
			paneCreateAcc.setVisible(true);
			break;
		case "createUser":
			paneMain.setVisible(true);
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
