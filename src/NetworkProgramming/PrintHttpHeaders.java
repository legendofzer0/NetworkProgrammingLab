package NetworkProgramming;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PrintHttpHeaders{
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.google.com";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            conn.connect();

            Map<String, List<String>> headers = conn.getHeaderFields();

            System.out.println("HTTP Headers for URL: " + urlString);
            System.out.println("-------------------------------------------------");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                if (headerName == null) {
                    System.out.println(headerValues.get(0));
                } else {
                    for (String value : headerValues) {
                        System.out.println(headerName + ": " + value);
                    }
                }
            }

            conn.disconnect();
    }
}
