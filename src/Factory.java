

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	
	public boolean startSiloLoadAction() throws RemoteException;
	
	public boolean reserveSilo1() throws RemoteException;

	
}
