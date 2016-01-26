

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	
	public void startSiloLoadAction(String user) throws RemoteException;
	
	public void reserveSilo1(String user) throws RemoteException;
	public void reserveSilo2(String user) throws RemoteException;
	public void reserveSilo3(String user) throws RemoteException;
	public void reserveSilo4(String user) throws RemoteException;

	public void reserveStove1(String user) throws RemoteException;
	public void reserveStove2(String user) throws RemoteException;
	public void reserveStove3(String user) throws RemoteException;
	public void startStove1(String user) throws RemoteException;
	public void startStove2(String user) throws RemoteException;
	public void startStove3(String user) throws RemoteException;
	
	public void startUnloader1(int amount, String user) throws RemoteException;
	
	//UPDATER

	public String silo1CurrentAmoutUpdate() throws RemoteException;
	public String silo2CurrentAmoutUpdate() throws RemoteException;
	public String silo3CurrentAmoutUpdate() throws RemoteException;
	public String silo4CurrentAmoutUpdate() throws RemoteException;
	
	
}
