package nl.evg.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	public String sayHello() throws RemoteException;
	public EmployerImpl getEmployer() throws RemoteException;
}
