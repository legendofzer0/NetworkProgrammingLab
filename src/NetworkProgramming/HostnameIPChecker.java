package NetworkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameIPChecker {
    public static void main(String[] args) {
        String hostname1 = "www.facebook.com";
        String hostname2 = "facebook.com";

        try {
            InetAddress address1 = InetAddress.getByName(hostname1);
            InetAddress address2 = InetAddress.getByName(hostname2);

            String ip1 = address1.getHostAddress();
            String ip2 = address2.getHostAddress();

            System.out.println(hostname1 + " IP: " + ip1);
            System.out.println(hostname2 + " IP: " + ip2);

            if (ip1.equals(ip2)) {
                System.out.println("Both hostnames resolve to the same IP address.");
            } else {
                System.out.println("Hostnames resolve to different IP addresses.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Could not resolve hostname: " + e.getMessage());
        }
    }
}
