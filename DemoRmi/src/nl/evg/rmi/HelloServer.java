package nl.evg.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer implements Hello {

	@Override
	public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
        
        try {
            // Create registry
            int port = 1098;
			Registry registry = LocateRegistry.createRegistry(port);

            
            HelloServer obj = new HelloServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            
            // Bind the remote object's stub in the registry
//            Registry registry = LocateRegistry.getRegistry(1098);
            registry.bind("Hello", stub);

            System.err.println("Server ready on port "+port);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
