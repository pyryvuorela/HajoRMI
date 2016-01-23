

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {	
		private String message;
		
	public FactoryImplementation() throws RemoteException {	
		super();
	}

	public String viesti(String ms) throws RemoteException {
		return ms;		
	}

	@Override
	public void saveMsg(String msg) throws RemoteException {
		message = msg;
	}

	@Override
	public String returnText(String ms) throws RemoteException {
		return ms;
	}

	@Override
	public String getMsg() throws RemoteException {
		return message;
	}	
	
}
