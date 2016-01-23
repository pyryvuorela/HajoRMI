

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	public void createNewUser(String name) throws RemoteException;
	public void setCurrentUser(newUser currentUser) throws RemoteException;
	public newUser getCurrentUser() throws RemoteException;
	
	public void startSiloLoadAction() throws RemoteException;
	public boolean reserveSilo1() throws RemoteException;

	
}
