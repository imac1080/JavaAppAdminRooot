package application;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
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
	           /*
	           System.out.println("result after Reading JSON Response");
	           JSONObject myResponse = new JSONObject(result);
	           System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
	           System.out.println("id- "+myResponse.getInt("id"));
	           System.out.println("result- "+myResponse.getString("result"));
	           */
	           inS.close();
	           conn.disconnect();
	           } catch (Exception e) {
	   			System.out.println(e);
	   		}
		}
	

}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;




	private static HttpURLConnection con;

    public static void main(String[] args) throws IOException {

        String url = "https://apiams2root.herokuapp.com/users/login";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {

                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());

        } finally {

            con.disconnect();
        }
    }
}

*/
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject; 

public class Conexion {
	public static void main(String[] args) {
     try {
    	 Conexion.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "https://apiams2root.herokuapp.com/users/me";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     System.out.println("result after Reading JSON Response");
     System.out.println("statusCode- "+myResponse.getString("statusCode"));
     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
     System.out.println("countryCode- "+myResponse.getString("countryCode"));
     System.out.println("countryName- "+myResponse.getString("countryName"));
     System.out.println("regionName- "+myResponse.getString("regionName"));
     System.out.println("cityName- "+myResponse.getString("cityName"));
     System.out.println("zipCode- "+myResponse.getString("zipCode"));
     System.out.println("latitude- "+myResponse.getString("latitude"));
     System.out.println("longitude- "+myResponse.getString("longitude"));
     System.out.println("timeZone- "+myResponse.getString("timeZone"));  
   }
}



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://webcode.me"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
*/