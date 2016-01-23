

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {	
	private SiloLoader siloLoader;
	
	private String currentUser;
	private Silo silo1;
	private Silo silo2;
	private Silo silo3;
	private Silo silo4;
	
	public FactoryImplementation() throws RemoteException {	
		super();
		this.siloLoader = new SiloLoader();
		this.silo1 = new Silo(currentUser, siloLoader);
		this.silo2 = new Silo(currentUser, siloLoader);
		this.silo3 = new Silo(currentUser, siloLoader);
		this.silo4 = new Silo(currentUser, siloLoader);
	}

	@Override
	public void userLogIn(String userName) throws RemoteException {
		newUser newuser = new newUser(userName);
	}		
	public void startSiloLoadAction() throws RemoteException {
		System.out.println("Toimii");
			siloLoader.start();
	}
	@Override
	public void reserveSilo1() throws RemoteException {
		silo1.start();	
	}
	public void reserveSilo2() throws RemoteException {
		silo2.start();
	}
	public void reserveSilo3() throws RemoteException {
		silo3.start();	
	}
	public void reserveSilo4() throws RemoteException {
		silo4.start();
	}
}
