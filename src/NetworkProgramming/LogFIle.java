package NetworkProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class LogFIle {
    public static void main(String[] args) {
        String logFilePath = "src/AdvanceJava/server.log";

        String logPattern =
                "(\\d+\\.\\d+\\.\\d+\\.\\d+) - - \\[(.*?)\\] \"(\\w+) (.*?) HTTP/\\d.\\d\" (\\d{3}) (\\d+)";

        Pattern pattern = Pattern.compile(logPattern);

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String ip = matcher.group(1);
                    String timestamp = matcher.group(2);
                    String method = matcher.group(3);
                    String resource = matcher.group(4);
                    String status = matcher.group(5);
                    String size = matcher.group(6);

                    System.out.println("IP: " + ip);
                    System.out.println("Timestamp: " + timestamp);
                    System.out.println("Method: " + method);
                    System.out.println("Resource: " + resource);
                    System.out.println("Status: " + status);
                    System.out.println("Response Body Size: " + size);
                    System.out.println("--------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }
    }
}
