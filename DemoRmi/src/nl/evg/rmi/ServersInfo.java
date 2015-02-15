package nl.evg.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServersInfo extends Remote {
	Integer getNofRegisteredServers() throws RemoteException;

	void incNofRegisteredServers() throws RemoteException;
}
