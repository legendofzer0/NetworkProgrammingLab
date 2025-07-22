package NetworkProgramming.SocketWithBuffers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 8000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream outputStream = socket.getOutputStream();

                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    System.out.println("Server received: " + inputLine);
                    outputStream.write(("Echo: " + inputLine + "\n").getBytes());
                    outputStream.flush();

                    if (inputLine.equalsIgnoreCase("exit")) {
                        System.out.println("Closing connection with client.");
                        socket.close();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
