package NetworkProgramming.SecureSocket;

import javax.net.ssl.*;
import java.io.*;

public class SecureClientDemo {
    public  final static String host = "www.example.com";
    public  final static int port = 443;
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(host, port);

            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println("Connection: close");
            out.println();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            sslSocket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
