package NetworkProgramming.RMI;

import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) throws Exception {
        AdderImp imp = new AdderImp();
        Registry registry = LocateRegistry.createRegistry( 1099);
        registry.rebind("Adder", imp);
    }
}
