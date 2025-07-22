package NetworkProgramming.SecureSocket;

import javax.net.ssl.*;

public class SecureServerDemo {
    public static final int PORT = 433;
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket ss = (SSLServerSocket) ssf.createServerSocket(PORT);
        System.out.println("Listening on port " + PORT);
        while (true) {
            SSLSocket socket = (SSLSocket) ss.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
        }
    }
}
