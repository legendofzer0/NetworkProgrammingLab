package NetworkProgramming.SecureSocket;

import javax.net.ssl.*;
import java.io.IOException;

public class SessionManagementExample {
    public final static String HOST = "localhost";
    public final static int PORT = 443;
    public static void main(String[] args) throws IOException {
        try {
            // Create an SSL socket with a secure connection
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT);

            // Start the SSL handshake
            sslSocket.startHandshake();

            // Get the SSL session associated with the socket
            SSLSession sslSession = sslSocket.getSession();

            // Access session information
            System.out.println("Session ID: " + sslSession.getId());
            System.out.println("Creation Time: " + sslSession.getCreationTime());
            System.out.println("Last Accessed Time: " + sslSession.getLastAccessedTime());
            System.out.println("Cipher Suite: " + sslSession.getCipherSuite());
            System.out.println("Peer Host: " + sslSession.getPeerHost());

            // Store and retrieve session values
            sslSession.putValue("Name", "Jenish");
            System.out.println("Session Value: " + sslSession.getValue("Name"));

            // Remove session value
            sslSession.removeValue("Name");

            // Invalidate the session
            sslSession.invalidate();

            // Close the SSL socket
            sslSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
