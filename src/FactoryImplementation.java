

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {

	public FactoryImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String viesti(String ms) throws RemoteException {
		// TODO Auto-generated method stub
		return ms;
	}
	
}
