package application;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conexion {
	private static String url = "https://apiams2root.herokuapp.com";

	public static JSONObject Post_JSON_Login(String email, String password) {
		// Users user=new Users();
		String query_url = url + "/users/login";
		String json = "{\"email\" : \"" + email + "\", \"password\" :  \"" + password + "\"}";
		try {
			URL url = new URL(query_url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			// read the response
			InputStream inS = new BufferedInputStream(conn.getInputStream());
			String resultado = IOUtils.toString(inS, "UTF-8");
			// System.out.println(resultado);
			// System.out.println("result after Reading JSON Response");
			JSONObject myResponse = new JSONObject(resultado);
			JSONObject user = myResponse.getJSONObject("user");
			// System.out.println(user.getString("_id"));
			// System.out.println(myResponse);
			// JSONArray jsonar=myResponse.getJSONObject("user").getJSONArray("tokens");
			// System.out.println(myResponse.getJSONObject("user").getString("_id"));
			// System.out.println( myResponse.getJSONObject("_id"));
			/*
			 * for (int i=0;i<jsonar.length();i++) {
			 * System.out.println(jsonar.getJSONObject(i).getString("_id")); }
			 */
			// System.out.println( myResponse.getJSONObject("_id"));
			// System.out.println("user- "+myResponse.getString("user"));
			// System.out.println("password- "+myResponse.getString("name"));
			// System.out.println("id- "+myResponse.getInt("_id"));
			inS.close();
			conn.disconnect();
			System.out.println("User connected successfully");
			return user;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void Post_JSON_LogOutAll(JSONObject user) {
		String query_url = url + "/users/me/logoutall";
		String activeToken = "";
		try {
			JSONArray arrtokens = user.getJSONArray("tokens");
			activeToken = arrtokens.getJSONObject(arrtokens.length() - 1).getString("token");
			// System.out.println(activeToken);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Authorization", "Bearer " + activeToken);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setRequestMethod("POST");
			// read the response
			InputStream inS = new BufferedInputStream(conn.getInputStream());
			String resultado = IOUtils.toString(inS, "UTF-8");
			System.out.println(resultado);
			inS.close();
			conn.disconnect();
			System.out.println("User logout all successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
