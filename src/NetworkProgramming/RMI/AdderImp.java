package NetworkProgramming.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderImp extends UnicastRemoteObject implements Adder {
    AdderImp() throws RemoteException {};

    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
