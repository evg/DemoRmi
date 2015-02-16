package nl.evg.rmi;

import java.rmi.RemoteException;

public class ServersInfoImpl implements ServersInfo {

	@Override
	public synchronized Integer getNofRegisteredServers() throws RemoteException {
		return nofRegisteredServers;
	}

	@Override
	public synchronized void incNofRegisteredServers() throws RemoteException {
		nofRegisteredServers++;
	}
	
	private int nofRegisteredServers = 1;

}
