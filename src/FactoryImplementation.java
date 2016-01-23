

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {	

		
	public FactoryImplementation() throws RemoteException {	
		super();
		SiloLoader siloloader = new SiloLoader();
	}

	@Override
	public void userLogIn(String userName) throws RemoteException {

	}		
	public boolean startSiloLoadAction() throws RemoteException {
		return false;	
	}
	@Override
	public boolean reserveSilo1() throws RemoteException {
		return false;	
	}
}
