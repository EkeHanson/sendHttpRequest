import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Test {

    public static void main(String[] args) {
        //  Method:java.net.Http.HttpClient
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8282/realms/demo/protocol/openid-connect/userinfo")).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenApply(Main::parse)
                .thenAccept(System.out::println) //This is to be used without the method below and without the line immediately above
                .join();
    }

    }


//    public static void main(String[] args) {
//        HttpClient client = HttpClient.newHttpClient();
//       // HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8282/realms/demo/protocol/openid-connect/userinfo")).build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println) .join();
//    }

