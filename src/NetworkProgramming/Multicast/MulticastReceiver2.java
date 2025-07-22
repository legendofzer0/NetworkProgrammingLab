package NetworkProgramming.Multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver2 {
    public static void main(String[] args) {
        int port = 4446;
        String groupIP = "230.0.0.1";

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(groupIP);
            socket.joinGroup(group); // join multicast group

            System.out.println("Listening for multicast messages on " + groupIP + ":" + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Receiver exiting...");
                    break;
                }
            }

            socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
