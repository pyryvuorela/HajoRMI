

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public String viesti(String ms) throws RemoteException;
	
	
}
