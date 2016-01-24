

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
		if(siloLoader.getIsReadyForUse() == true){
			System.out.println("Kuljetinta painettu");
			Thread loaderthread = new Thread(siloLoader);
			loaderthread.start();
		}else{
			System.out.println("Kuljetin ei ole valmis");
		}
	}
	@Override
	public void reserveSilo1() throws RemoteException {
		if(silo1.isSiloFree() == true){
			System.out.println("Silo1 varausta painettu");
			Thread silo1thread = new Thread(silo1);
			silo1thread.start();
		}else{
			System.out.println("Silo1 on kaytossa");
		}	
	}
	public void reserveSilo2() throws RemoteException {
		if(silo2.isSiloFree() == true){
			System.out.println("Silo2 varausta painettu");
			Thread silo2thread = new Thread(silo2);
			silo2thread.start();
		}else{
			System.out.println("Silo2 on kaytossa");
		}
	}
	public void reserveSilo3() throws RemoteException {
		if(silo3.isSiloFree() == true){
			System.out.println("Silo3 varausta painettu");
			Thread silo3thread = new Thread(silo3);
			silo3thread.start();
		}else{
			System.out.println("Silo3 on kaytossa");
		}	
	}
	public void reserveSilo4() throws RemoteException {
		if(silo4.isSiloFree() == true){
			System.out.println("Silo4 varausta painettu");
			Thread silo4thread = new Thread(silo4);
			silo4thread.start();
		}else{
			System.out.println("Silo1 on kaytossa");
		}
	}
}
