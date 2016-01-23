

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	
	public void startSiloLoadAction() throws RemoteException;
	
	public void reserveSilo1() throws RemoteException;
	public void reserveSilo2() throws RemoteException;
	public void reserveSilo3() throws RemoteException;
	public void reserveSilo4() throws RemoteException;
	
}
