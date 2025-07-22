package NetworkProgramming;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceIp {
    public static void main(String[] args) throws SocketException {
        String name = "eth0";
        NetworkInterface iface = NetworkInterface.getByName(name);
        if (iface == null) {
            System.out.println("No network interface found");
        }
        else {
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            System.out.println("IP addresses:");
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                System.out.println(address.getHostAddress());
            }
        }

    }
}
