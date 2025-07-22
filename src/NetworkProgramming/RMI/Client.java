package NetworkProgramming.RMI;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Adder adder = (Adder) registry.lookup("Adder");
            System.out.println(adder.add(34,3434));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
