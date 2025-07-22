package NetworkProgramming.Multicast;

import java.net.*;
import java.util.Scanner;

public class MulticastSender {
    public static void main(String[] args) {
        try  {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            InetAddress group = InetAddress.getByName("230.0.0.1");
            int port = 4446;

            while (true) {
                System.out.print("Enter message to multicast (or type 'exit'): ");
                String message = scanner.nextLine();
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);
                System.out.println("Sent: " + message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Sender exiting...");
                    break;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
