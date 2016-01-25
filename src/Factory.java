

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	
	public void startSiloLoadAction() throws RemoteException;
	
	public void reserveSilo1() throws RemoteException;
	public void reserveSilo2() throws RemoteException;
	public void reserveSilo3() throws RemoteException;
	public void reserveSilo4() throws RemoteException;
	
	//UPDATER
	public String silo1CurrentAmoutUpdate() throws RemoteException;
	public String silo2CurrentAmoutUpdate() throws RemoteException;
	public String silo3CurrentAmoutUpdate() throws RemoteException;
	public String silo4CurrentAmoutUpdate() throws RemoteException;
	
}
