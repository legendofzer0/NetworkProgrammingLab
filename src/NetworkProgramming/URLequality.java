package NetworkProgramming;

import java.io.IOException;
import java.net.*;

public class URLequality {
    public static void main(String[] args) throws Exception{
        try {
            URL u1 = new URL("http://www.example.org/");
            URL u2 = new URL("http://example.org/");
            if (u1.equals(u2)) {
                System.out.println(u1 + " is the same as " + u2);
            } else {
                System.out.println(u1 + " is not the same as " + u2);
            }
            System.out.println(u1.toString());
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
