package NetworkProgramming;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetWorkInterface {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = netInterfaces.nextElement();
            System.out.println("Interface Name: "+netInterface.getName());
            System.out.println("Interface Display Name: "+netInterface.getDisplayName());
        }
    }
}
