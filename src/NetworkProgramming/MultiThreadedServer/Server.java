package NetworkProgramming.MultiThreadedServer;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                ServerThread clientThread = new ServerThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket connection;

    public ServerThread(Socket connection) {
        this.connection = connection;
    }

    public void run() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                OutputStream outputStream = connection.getOutputStream();
        ) {
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println("Server received: " + inputLine);
                outputStream.write(("Echo: " + inputLine + "\n").getBytes());
                outputStream.flush();

                if (inputLine.equalsIgnoreCase("exit")) {
                    System.out.println("Closing connection with client.");
                    connection.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected.");
            // e.printStackTrace(); // Optional: print stack trace if needed
        }
    }
}
