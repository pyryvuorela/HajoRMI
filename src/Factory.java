

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public String returnText(String ms) throws RemoteException;

	public void saveMsg(String msg) throws RemoteException;
	
	public String getMsg() throws RemoteException;

	
}
