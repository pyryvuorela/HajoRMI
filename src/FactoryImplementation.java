

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
	
	private Unloader unloader1;
	private Unloader unloader2;
	
	private Tank tank1;
	
	private Pump pump1;


	
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
		this.unloader1 = new Unloader();
		this.unloader2 = new Unloader();
		this.tank1 = new Tank();
	}

	public void userLogIn(String userName) throws RemoteException {
		users.checkLogInRegisterStatus(userName);
	}	
	//Tassa tulee nullpointteri jos kirjautuu jollain ja varaa seka tayttaa siilon ja sit vaihtaa kayttajaa ja painaa SiloLoaderia eika oo varannu yhtaan siiloo
	public void startSiloLoadAction(String user) throws RemoteException {
		System.out.println("Toimii tahan asti?");
		 if(silo1.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
			if(!siloLoader.getLoaderisUsed()){
					new Thread(siloLoader).start();
					new Thread(silo1).start();
			}
		}
		 else if(silo2.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					new Thread(siloLoader).start();
					new Thread(silo2).start();
				}
		}
		 else if(silo3.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					new Thread(siloLoader).start();
					new Thread(silo3).start();
				}
		}
		 else if(silo4.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					new Thread(siloLoader).start();
					new Thread(silo4).start();
				}
		}
		 else {
			 System.out.println("Varaa joku siilo, ennen tayttajan kayttoa!");
		 }
	}
	public void reserveSilo1(String user) throws RemoteException {
			System.out.println("Silo1 varausta painettu");
			silo1.setCurrentUser(user);
	}
	public void reserveSilo2(String user) throws RemoteException {
			System.out.println("Silo2 varausta painettu");
			silo2.setCurrentUser(user);
	}
	public void reserveSilo3(String user) throws RemoteException {
			System.out.println("Silo3 varausta painettu");
			silo3.setCurrentUser(user);
	}
	public void reserveSilo4(String user) throws RemoteException {
			System.out.println("Silo4 varausta painettu");
			silo4.setCurrentUser(user);
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
	public void startStove1(String user) throws RemoteException {
		stove1.setCurrentUser(user);
		new Thread(stove1).start();
	}
	public void startStove2(String user) throws RemoteException {
		stove2.setCurrentUser(user);
		new Thread(stove2).start();
	}
	public void startStove3(String user) throws RemoteException {
		stove3.setCurrentUser(user);
		new Thread(stove3).start();
	}
	
	public void startUnloader1(int amount, String user) throws RemoteException {
		if(silo1.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo2.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo3.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo4.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader1.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
	}
	public void startUnloader2(int amount, String user) throws RemoteException {
		if(silo1.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo1.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo2.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo2.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo3.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo3.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
		else if(silo4.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove1.setMaterialAmount(amount);
			}			
			else if(stove2.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove2.setMaterialAmount(amount);
			}
			else if(stove3.getReservedUser().equals(user)){
				silo4.removeSilosContent(amount);		
				unloader2.setUnloadAmount(amount);
				stove3.setMaterialAmount(amount);
			}
		}
	}
	public void reserveTank1(String user) throws RemoteException {
		tank1.setReservedUser(user);
	}
	public void startPump1(String user) throws RemoteException {
		System.out.println("pumppu");
		if(stove1.getReservedUser().equals(tank1.getReservedUser())){
			pump1.setTank(tank1);
			pump1.setMovedAmount(stove1.getCurrentBatch());
			new Thread(pump1).start();
		}
	}
	// UPDATER
	public String silo1CurrentAmountUpdate() throws RemoteException{
		return Integer.toString(silo1.getCurrentAmount());
	}
	public String silo2CurrentAmountUpdate() throws RemoteException{
		return Integer.toString(silo2.getCurrentAmount());
	}
	public String silo3CurrentAmountUpdate() throws RemoteException{
		return Integer.toString(silo3.getCurrentAmount());
	}
	public String silo4CurrentAmountUpdate() throws RemoteException{
		return Integer.toString(silo4.getCurrentAmount());
	}

	public String proc1CurrentUpdate() throws RemoteException {
		return Integer.toString(stove1.getCurrentMaterial());
	}

	public String proc2CurrentUpdate() throws RemoteException {
		return Integer.toString(stove2.getCurrentMaterial());
	}

	public String proc3CurrentUpdate() throws RemoteException {
		return Integer.toString(stove3.getCurrentMaterial());
	}



	public String proc1CurrentBatchUpdate() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String proc2CurrentBatchUpdate() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String proc3CurrentBatchUpdate() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean stove1GetStartPressed() throws RemoteException {
		return stove1.getStartPressed();
	}

	public boolean stove2GetStartPressed() throws RemoteException {
		// TODO Auto-generated method stub
		return stove2.getStartPressed();
	}

	public boolean stove3GetStartPressed() throws RemoteException {
		// TODO Auto-generated method stub
		return stove3.getStartPressed();
	}
	

}
