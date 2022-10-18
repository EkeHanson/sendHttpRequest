import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    private static final String USER_AGENT = "chrome";
    private static final String GET_URL = "http://localhost:8282/realms/demo/protocol/openid-connect/userinfo";
    private static final String POST_PARAMS = "userName=Pankaj";

    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        //con.setRequestProperty("Token", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJia1Rabjk2ajJENXlWdFBEQ1BDMWlBVmNYT3FQbXk0M0pmWEJwUzByLXVNIn0.eyJleHAiOjE2NjYxMTU3NzksImlhdCI6MTY2NjExNTQ3OSwianRpIjoiZTkzNTczZGMtMDA2ZC00NTY1LTk4ZDQtMmExNzZjYzEyNjljIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MjgyL3JlYWxtcy9kZW1vIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRlNTUzMGNhLTQ3MDMtNGRlMi1hYWM1LTg1YzY4YmUzYmUyMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InByb2R1Y3QtYXBwIiwic2Vzc2lvbl9zdGF0ZSI6ImJhYTljYzRiLWRlNzgtNDFkNy1iNmNmLWZjNDA0NGJmNDVjNSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZGVtbyIsInVzZXIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJiYWE5Y2M0Yi1kZTc4LTQxZDctYjZjZi1mYzQwNDRiZjQ1YzUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJFa2VuZS1vbndvbiBBYnJhaGFtIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWtlbmVoYW5zb24iLCJnaXZlbl9uYW1lIjoiRWtlbmUtb253b24iLCJmYW1pbHlfbmFtZSI6IkFicmFoYW0iLCJlbWFpbCI6ImVrZW5laGFuc29uQGdtYWlsLmNvbSJ9.IA18KvpT1xXYDEv4f3F026UbYEr8QOaOcu170GbYtY_V-1fsOb_ytQ_03F-C2CLOPCZWPzL5Q7AFBopoE-d-Yw2uUChytXFhjS76qn-H5rMekEKqHd9J02J-HGD6xW9hRHJ7MS-VawUZyE1KJGdyoa7D9RIAr1YaS8Rsjvog8DL3xREZj00XmqCU3OHOFN7OxX7ni7Y5OcO1q4hlEBKQxiT_qMTkym9eA_UIItmKrorEM3RK3L0klQqKizZr3h-4TG-6Ng7sZEuZKN6eWlsqtftsHhKL6vFESfdwCDWflEPidPAOcsw84WhC3swec6lYHUv0ztk70PGNYuIdM62o5w.eyJleHAiOjE2NjYxMTU3NzksImlhdCI6MTY2NjExNTQ3OSwianRpIjoiZTkzNTczZGMtMDA2ZC00NTY1LTk4ZDQtMmExNzZjYzEyNjljIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MjgyL3JlYWxtcy9kZW1vIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRlNTUzMGNhLTQ3MDMtNGRlMi1hYWM1LTg1YzY4YmUzYmUyMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InByb2R1Y3QtYXBwIiwic2Vzc2lvbl9zdGF0ZSI6ImJhYTljYzRiLWRlNzgtNDFkNy1iNmNmLWZjNDA0NGJmNDVjNSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZGVtbyIsInVzZXIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJiYWE5Y2M0Yi1kZTc4LTQxZDctYjZjZi1mYzQwNDRiZjQ1YzUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJFa2VuZS1vbndvbiBBYnJhaGFtIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWtlbmVoYW5zb24iLCJnaXZlbl9uYW1lIjoiRWtlbmUtb253b24iLCJmYW1pbHlfbmFtZSI6IkFicmFoYW0iLCJlbWFpbCI6ImVrZW5laGFuc29uQGdtYWlsLmNvbSJ9.IA18KvpT1xXYDEv4f3F026UbYEr8QOaOcu170GbYtY_V-1fsOb_ytQ_03F-C2CLOPCZWPzL5Q7AFBopoE-d-Yw2uUChytXFhjS76qn-H5rMekEKqHd9J02J-HGD6xW9hRHJ7MS-VawUZyE1KJGdyoa7D9RIAr1YaS8Rsjvog8DL3xREZj00XmqCU3OHOFN7OxX7ni7Y5OcO1q4hlEBKQxiT_qMTkym9eA_UIItmKrorEM3RK3L0klQqKizZr3h-4TG-6Ng7sZEuZKN6eWlsqtftsHhKL6vFESfdwCDWflEPidPAOcsw84WhC3swec6lYHUv0ztk70PGNYuIdM62o5w.eyJleHAiOjE2NjYxMTU2MTksImlhdCI6MTY2NjExNTMxOSwianRpIjoiNzA0NDNmYWEtNjU2Yi00MjY0LTk4NWYtMzVkYTlhNTY2YWJlIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MjgyL3JlYWxtcy9kZW1vIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRlNTUzMGNhLTQ3MDMtNGRlMi1hYWM1LTg1YzY4YmUzYmUyMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InByb2R1Y3QtYXBwIiwic2Vzc2lvbl9zdGF0ZSI6IjUxNGU3MTI5LTg5ODYtNGU3ZC1iMDNlLTZkZmM2NDA5N2JlZiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZGVtbyIsInVzZXIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiI1MTRlNzEyOS04OTg2LTRlN2QtYjAzZS02ZGZjNjQwOTdiZWYiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJFa2VuZS1vbndvbiBBYnJhaGFtIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZWtlbmVoYW5zb24iLCJnaXZlbl9uYW1lIjoiRWtlbmUtb253b24iLCJmYW1pbHlfbmFtZSI6IkFicmFoYW0iLCJlbWFpbCI6ImVrZW5laGFuc29uQGdtYWlsLmNvbSJ9.XUMO22RnBfaGFii45dTtRXirpDM1xHcNbV80EEDDFQBFWWv4KEcGD-dxKfUU1aHCjltm1CLB9-tXCv7zL96HtYUnIhAsEzGOarTMNckHJYS-6-bNpP6AMT01xd8_KN8B6to95Lq0iMzCkWqlrTGPtgSOOYdsOFZL88Qbb99pkHQxQcLYz9iIwGd_3spLncATuEwblHvJ1sCZ0NT2OUxhHRQLVi6DaX_WKVBzLaprM87WEcPQGIViJ_h7DPgsp4PWXXYaqNMFbvH7NDBqSugcFk6bxiv9CuQSbommuyv-QDPs_m61gRzHEHwFqRhag13YYdbvTmV9AKuqBUV1S4gB8A");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }

}