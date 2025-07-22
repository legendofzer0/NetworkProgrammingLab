package NetworkProgramming;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressTypeTest {
    public static void main(String[] args) throws UnknownHostException {
    String ip = "172.16.0.2";
    InetAddress addr = InetAddress.getByName(ip);
    if(addr instanceof Inet4Address){
        System.out.println("IPv4 address");
    }
    else if(addr instanceof Inet6Address) {
        System.out.println("IPv6 address");
    }
    else {
        System.out.println("Unknown IP address");
    }
    }
}
