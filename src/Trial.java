import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Trial {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .headers("accept", "application/json")
                .headers("accept", "application/json")
                .headers("client_id", "product-app")
                .uri(URI.create("http://localhost:8282/realms/demo/protocol/openid-connect/userinfo"))
                .setHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJia1Rabjk2ajJENXlWdFBEQ1BDMWlBVmNYT3FQbXk0M0pmWEJwUzByLXVNIn0.eyJleHAiOjE2NjYxMjkzNzMsImlhdCI6MTY2NjEyOTA3MywianRpIjoiODdhNTVjZWQtOGYwZS00M2U2LTlmYWUtODkyNmUwNTRmYzhkIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MjgyL3JlYWxtcy9kZW1vIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRlNTUzMGNhLTQ3MDMtNGRlMi1hYWM1LTg1YzY4YmUzYmUyMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InByb2R1Y3QtYXBwIiwic2Vzc2lvbl9zdGF0ZSI6Ijk3YmE0MWEwLTQ2YWItNGI1Yi05NzljLTcxNzk4ZWU0NTZiZCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZGVtbyIsInVzZXIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiI5N2JhNDFhMC00NmFiLTRiNWItOTc5Yy03MTc5OGVlNDU2YmQiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJFa2VuZS1vbndvbiBBYnJhaGFtIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWtlbmVoYW5zb24iLCJnaXZlbl9uYW1lIjoiRWtlbmUtb253b24iLCJmYW1pbHlfbmFtZSI6IkFicmFoYW0iLCJlbWFpbCI6ImVrZW5laGFuc29uQGdtYWlsLmNvbSJ9.M7w_-DWr80-M9AjgZYTm0ndOB5Vk_89G-cqV2dKoE6fUXMaEAONc18VD8Kz0ClDsKXmIztyV0X6KZO3a-ro1BUOoNkTdFzNWdbYQ4b-QMoHCzdEerdpOtB2AIhjWedleQcZHz111NBKq0Z0zRQUyxnz6QgHszt_hoCpOew861lNioR8iIo8eEK2ORrOrJyeAsjJ8WFk2M23G_SzLxBeat3KjqBzve5gIlVxmWtTQ1yIv--ZTtTF17Yoeya7Flv4xl2ujGVgKdEBiR3vy67j0lrta02go1XF9nicnz5UGxdg9_CthE3eD_xBQr1WHxjV_TZjcrTP80eqraN0s7aNCig")
                .build();
                 client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}