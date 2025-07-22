package NetworkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class CookieManagement{
    public static void main(String[] args) {
        String url1 = "https://httpbin.org/cookies/set?token=abc123";
        String url2 = "https://httpbin.org/cookies";

        // Create a CookieManager with custom policy
        CookiePolicy policy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                // Accept all cookies except from .gov
                if (uri.getHost().endsWith(".gov")) {
                    return false;
                }
                return true;
            }
        };

        CookieManager manager = new CookieManager(null, policy);
        CookieHandler.setDefault(manager);

        // Send requests
        sendRequest(url2);
        sendRequest(url1);
        sendRequest(url2);

        // Access cookie store
        CookieStore store = manager.getCookieStore();

        // Print stored cookies
        System.out.println("\nStored Cookies:");
        List<HttpCookie> cookies = store.getCookies();
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }

        // Print cookies by domain
        System.out.println("\nCookies by URI:");
        List<URI> uris = store.getURIs();
        for (URI uri : uris) {
            System.out.println(uri + ":");
            for (HttpCookie c : store.get(uri)) {
                System.out.println("  " + c);
            }
        }

    }

    private static void sendRequest(String urlString) {
        System.out.println("\nConnecting to: " + urlString);
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setConnectTimeout(3000);
            con.setReadTimeout(3000);

            con.connect();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            Map<String, List<String>> headers = con.getHeaderFields();
            List<String> setCookies = headers.get("Set-Cookie");
            if (setCookies != null) {
                System.out.println("Set-Cookie Headers:");
                for (String cookie : setCookies) {
                    System.out.println(cookie);
                }
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // print first few lines of response (optional)
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
