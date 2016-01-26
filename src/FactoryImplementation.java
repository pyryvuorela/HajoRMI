

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {	
	
	private Users users;
	
	private SiloLoader siloLoader;
	private Silo silo1;
	private Silo silo2;
	private Silo silo3;
	private Silo silo4;
	private Stove stove1;
	private Stove stove2;
	private Stove stove3;
	private Stove stove4;
	private Thread loaderthread;
	private Thread silo1thread;
	private Thread silo2thread;
	private Thread silo3thread;
	private Thread silo4thread;
	private Thread stove1thread;
	private Thread stove2thread;
	private Thread stove3thread;

	
	public FactoryImplementation() throws RemoteException {	
		super();
		this.users = new Users();
		this.siloLoader = new SiloLoader();
		this.silo1 = new Silo();
		this.silo2 = new Silo();
		this.silo3 = new Silo();
		this.silo4 = new Silo();
		this.stove1 =  new Stove();
		this.stove2 =  new Stove();
		this.stove3 =  new Stove();
		this.loaderthread = new Thread(siloLoader);
		this.silo1thread = new Thread(silo1);
		this.silo2thread = new Thread(silo2);
		this.silo3thread = new Thread(silo3);
		this.silo4thread = new Thread(silo4);
		this.stove1thread = new Thread(stove1);
		this.stove2thread = new Thread(stove2);
		this.stove3thread = new Thread(stove3);
	}

	public void userLogIn(String userName) throws RemoteException {
		users.checkLogInRegisterStatus(userName);
	}	
	public void startSiloLoadAction() throws RemoteException {
			System.out.println("Kuljetinta painettu");
			loaderthread.start();
	}
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
	public void reserveStove1(String user) throws RemoteException {
		System.out.println("Stove1 varausta painettu");
		stove1.reserveStove(user);
	}
	public void reserveStove2(String user) throws RemoteException {
		stove2.reserveStove(user);
	}
	public void reserveStove3(String user) throws RemoteException {
		stove3.reserveStove(user);
	}
	public void startStove1() throws RemoteException {
		System.out.println("Stove1 aloitettu!");
		stove1thread.start();
	}
	public void startStove2() throws RemoteException {
		stove2thread.start();
	}
	public void startStove3() throws RemoteException {
		stove3thread.start();
	}
	
	// UPDATER
	public String silo1CurrentAmoutUpdate() throws RemoteException{
		return Integer.toString(silo1.getCurrentAmount());
	}
	public String silo2CurrentAmoutUpdate() throws RemoteException{
		return Integer.toString(silo2.getCurrentAmount());
	}
	public String silo3CurrentAmoutUpdate() throws RemoteException{
		return Integer.toString(silo3.getCurrentAmount());
	}
	public String silo4CurrentAmoutUpdate() throws RemoteException{
		return Integer.toString(silo4.getCurrentAmount());
	}
	public String currentUserUpdate() throws RemoteException {
		return users.getCurrentUser();
	}


}
