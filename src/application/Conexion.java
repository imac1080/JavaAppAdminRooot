package application;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
public class Conexion {

		public static void main(String[] args) {
			Post_JSON();
		}
		public static void Post_JSON() {
	           String query_url = "https://apiams2root.herokuapp.com/users/login";
	           String json = "{\"email\" : \"pepe@app.com\", \"password\" :  \"12345678\"}";
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
	           System.out.println(resultado);
	           
	           System.out.println("result after Reading JSON Response");
	           JSONObject myResponse = new JSONObject(resultado);
	           System.out.println(myResponse);
	           System.out.println("user- "+myResponse.getString("user"));
	           System.out.println("id- "+myResponse.getInt("_id"));
	           System.out.println("password- "+myResponse.getString("password"));
	           
	           inS.close();
	           conn.disconnect();
	           } catch (Exception e) {
	   			System.out.println(e);
	   		}
		}
	

}
