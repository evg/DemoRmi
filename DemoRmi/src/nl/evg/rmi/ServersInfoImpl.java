package nl.evg.rmi;

import java.rmi.RemoteException;

public class ServersInfoImpl implements ServersInfo {

	@Override
	public Integer getNofRegisteredServers() throws RemoteException {
		return nofRegisteredServers;
	}

	@Override
	public void incNofRegisteredServers() throws RemoteException {
		nofRegisteredServers++;
	}
	
	private int nofRegisteredServers = 1;

}
