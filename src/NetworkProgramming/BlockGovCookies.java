package NetworkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class BlockGovCookies {
    public static void main(String[] args) {
        String govUrl = "https://www.nasa.gov";
        String nonGovUrl = "https://httpbin.org/cookies/set?cookie1=value1";

        CookieManager cookieManager = new CookieManager(null, new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                if (uri.getHost().endsWith(".gov")) {
                    System.out.println("Blocking cookie from: " + uri.getHost() + " → " + cookie);
                    return false;
                }
                System.out.println("Allowing cookie from: " + uri.getHost() + " → " + cookie);
                return true;
            }
        });
        CookieHandler.setDefault(cookieManager);

        fetchPage(govUrl);
        fetchPage(nonGovUrl);

        System.out.println("\nStored Cookies After Requests:");
        CookieStore store = cookieManager.getCookieStore();
        List<HttpCookie> cookies = store.getCookies();
        if (cookies.isEmpty()) {
            System.out.println("No cookies stored.");
        } else {
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie);
            }
        }
    }

    private static void fetchPage(String urlString) {
        System.out.println("\nFetching: " + urlString);
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
                System.out.println("Set-Cookie headers:");
                for (String header : setCookies) {
                    System.out.println(header);
                }
            } else {
                System.out.println("No Set-Cookie header received.");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            int lines = 0;
            while ((line = reader.readLine()) != null && lines++ < 5) {
                System.out.println(line);
            }
            System.out.println("_______________________________________");
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
