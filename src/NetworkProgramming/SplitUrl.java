package NetworkProgramming;

import java.net.URL;
import java.net.MalformedURLException;

public class SplitUrl {
    public static void main(String[] args) throws MalformedURLException {
        String urlString = "https://www.localhost.com:8080/home?search=hello#new";

            URL url = new URL(urlString);

            System.out.println("Full URL: " + url);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + (url.getPort() != -1 ? url.getPort() : "Default"));
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Fragment: " + url.getRef());

    }
}

