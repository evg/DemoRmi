package nl.evg.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

    private HelloClient() {}

    public static void main(String[] args) {

        String host = null;
        int port = 1098;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            ServersInfo serversInfo = (ServersInfo) registry.lookup("serversinfo");
            for(int i=0; i<serversInfo.getNofRegisteredServers(); i++)
            {
            	Hello stub = (Hello) registry.lookup("Hello created by server-"+i);
            	String response = stub.sayHello();
            	System.out.println("response from server "+i+": " + response);
            	EmployerImpl emp = stub.getEmployer();
                System.out.println("emp="+emp+"; oid="+emp.oid);
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
