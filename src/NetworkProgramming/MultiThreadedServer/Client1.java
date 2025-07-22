package NetworkProgramming.MultiThreadedServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8000);
             Scanner sc = new Scanner(System.in);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {  // auto-flush enabled

            while (true) {
                System.out.println("Enter what to send:");
                String msg = sc.nextLine();

                // Send message with newline
                pw.println(msg);

                // Read single line response from server
                String response = br.readLine();
                System.out.println("Response from Server: " + response);

                if (msg.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
