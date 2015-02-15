package nl.evg.rmi;

import java.net.BindException;
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
            String name = "server-0";
            Registry registry = null;
            try
            {
            	registry = LocateRegistry.createRegistry(port);
            	System.out.println(String.format("First server! Created RMI registry on port %d",port));
            	ServersInfoImpl serversInfo = new ServersInfoImpl();
                ServersInfo serversInfoRemote = (ServersInfo)UnicastRemoteObject.exportObject(serversInfo, 0);
            	System.out.println(String.format("Exported ServersInfoImpl"));
            	registry.bind("serversinfo", serversInfoRemote);
            	System.out.println(String.format("Bound ServersInfoImpl instance to registry"));
            }
            catch(Exception exc)
            {
	            	System.out.println(String.format("Unable to start RMI registry on port %d; already started by other server?",port));
	            	registry = LocateRegistry.getRegistry(1098);
	            	System.out.println(String.format("Bound to RMI registry on port %d",port));
	            	ServersInfo serversInfo = (ServersInfo)registry.lookup("serversinfo");
	            	System.out.println(String.format("Found ServersInfo in registry, nofServers=%d",serversInfo.getNofRegisteredServers()));
	            	name = "server-"+serversInfo.getNofRegisteredServers();
	            	serversInfo.incNofRegisteredServers();
	            	System.out.println(String.format("Increased nofServers to %d",serversInfo.getNofRegisteredServers()));
            }

            
            HelloServer obj = new HelloServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            
            // Bind the remote object's stub in the registry
            registry.bind("Hello created by "+name, stub);

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
