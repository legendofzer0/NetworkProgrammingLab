package NetworkProgramming;

import java.io.*;
import java.net.*;

public class DownloadProtectedPageWithAuthenticator {

    public static void main(String[] args) throws IOException, MalformedURLException {
        String urlString = "https://httpbin.org/basic-auth/user/pass";
        String username = "user";
        String password = "pass";

        // Set the default Authenticator
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Optional: set User-Agent
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                System.out.println("Page Content:\n");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("Failed to download. Server responded with: " + responseCode);
        }
    }
}
