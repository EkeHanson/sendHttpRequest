import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SecondMethod {

        private static HttpURLConnection connection;

        public static void main(String[] args) {

            //Method1: java.net.HttpURLConnection

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/albums");
                connection = (HttpURLConnection) url.openConnection();

                //Request Setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int status = connection.getResponseCode();
                //System.out.println(status);
                if (status > 299) {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                }
               // System.out.println(responseContent.toString());
                parse(responseContent.toString());


            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                connection.disconnect();
            }
        }
        public static  String parse(String responseBody){
            JSONArray albums = new JSONArray(responseBody);
            for(int i =0; i<albums.length(); i++){
                JSONObject album = albums.getJSONObject(i);
                int id = album.getInt("id");
                int userId = album.getInt("userId");
                String title = album.getString("title");
                System.out.println(id+ " " + title +" " + userId);
            }
            return  null;
        }
    }
