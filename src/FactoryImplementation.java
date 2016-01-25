

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
	private Thread loaderthread;
	private Thread silo1thread;
	private Thread silo2thread;
	private Thread silo3thread;
	private Thread silo4thread;
	
	public FactoryImplementation() throws RemoteException {	
		super();
		this.siloLoader = new SiloLoader();
		this.silo1 = new Silo(currentUser, siloLoader);
		this.silo2 = new Silo(currentUser, siloLoader);
		this.silo3 = new Silo(currentUser, siloLoader);
		this.silo4 = new Silo(currentUser, siloLoader);
		this.loaderthread = new Thread(siloLoader);
		this.silo1thread = new Thread(silo1);
		this.silo2thread = new Thread(silo2);
		this.silo3thread = new Thread(silo3);
		this.silo4thread = new Thread(silo4);
	}

	@Override
	public void userLogIn(String userName) throws RemoteException {
		newUser newuser = new newUser(userName);
	}		
	public void startSiloLoadAction() throws RemoteException {
			System.out.println("Kuljetinta painettu");
			loaderthread.start();
	}
	@Override
	public void reserveSilo1() throws RemoteException {
			System.out.println("Silo1 varausta painettu");
			silo1thread.start();
	}
	public void reserveSilo2() throws RemoteException {
			System.out.println("Silo2 varausta painettu");
			silo2thread.start();
	}
	public void reserveSilo3() throws RemoteException {
			System.out.println("Silo3 varausta painettu");
			silo3thread.start();
	}
	public void reserveSilo4() throws RemoteException {
			System.out.println("Silo4 varausta painettu");
			silo4thread.start();
	}
	
	// UPDATER
	public String silo1CurrentAmoutUpdate() throws RemoteException{
		return Integer.toString(silo1.getCurrentAmount());
	}
}
