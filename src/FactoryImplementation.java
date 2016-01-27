

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
	private Tank tank2;
	private Tank tank3;
	private Tank tank4;
	private Tank tank5;
	private Tank tank6;
	private Tank tank7;
	private Tank tank8;
	private Tank tank9;
	private Tank tank10;
	
	
	private Pump pump1;
	private Pump pump2;
	private BottlePump Bpump1;
	private BottlePump Bpump2;


	
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
		this.tank2 = new Tank();
		this.tank3 = new Tank();
		this.tank4 = new Tank();
		this.tank5 = new Tank();
		this.tank6 = new Tank();
		this.tank7 = new Tank();
		this.tank8 = new Tank();
		this.tank9 = new Tank();
		this.tank10 = new Tank();
		this.pump1 = new Pump();
		this.pump2 = new Pump();
		
	}

	public void userLogIn(String userName) throws RemoteException {
		users.checkLogInRegisterStatus(userName);
	}
	public void startSiloLoadAction(String user) throws RemoteException {
		System.out.println("Toimii tahan asti?");
		 
		if(silo1.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo1.getCapacity() - silo1.getCurrentAmount()) / 2);
					new Thread(siloLoader).start();
					new Thread(silo1).start();
			}
		}
		 else if(silo2.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo2.getCapacity() - silo2.getCurrentAmount()) / 2);
					new Thread(siloLoader).start();
					new Thread(silo2).start();
				}
		}
		 else if(silo3.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo3.getCapacity() - silo3.getCurrentAmount()) / 2);
					new Thread(siloLoader).start();
					new Thread(silo3).start();
				}
		}
		 else if(silo4.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo4.getCapacity() - silo4.getCurrentAmount()) / 2);
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

	public void startPump1(String user) throws RemoteException {
		if(stove1.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}
		}
		else if(stove2.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}	
		}
		else if(stove3.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}	
		}
	}
	public void startPump2(String user) throws RemoteException {
		if(stove1.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}
		}
		else if(stove2.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}	
		}
		else if(stove3.getReservedUser().equals(user)){
			if(tank1.getReservedUser().equals(user)){
				tank1.setCurrentAmount(stove1.getCurrentBatch());
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.setCurrentAmount(stove1.getCurrentBatch());
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.setCurrentAmount(stove1.getCurrentBatch());
			}	
		}
	}
	public void startBottlePump1(String user) throws RemoteException {
			if(tank1.getReservedUser().equals(user)){
				tank1.removeContent();
			}	
			else if(tank2.getReservedUser().equals(user)){
				tank2.removeContent();
			}
			else if(tank3.getReservedUser().equals(user)){
				tank3.removeContent();
			}
			else if(tank4.getReservedUser().equals(user)){
				tank4.removeContent();
			}
			else if(tank5.getReservedUser().equals(user)){
				tank5.removeContent();
			}
			else if(tank6.getReservedUser().equals(user)){
				tank6.removeContent();
			}
			else if(tank7.getReservedUser().equals(user)){
				tank7.removeContent();
			}
			else if(tank8.getReservedUser().equals(user)){
				tank8.removeContent();
			}
			else if(tank9.getReservedUser().equals(user)){
				tank9.removeContent();
			}
			else if(tank10.getReservedUser().equals(user)){
				tank10.removeContent();
			}	
		}	

	public void startBottlePump2(String user) throws RemoteException {
		if(tank1.getReservedUser().equals(user)){
			tank1.removeContent();
		}	
		else if(tank2.getReservedUser().equals(user)){
			tank2.removeContent();
		}
		else if(tank3.getReservedUser().equals(user)){
			tank3.removeContent();
		}
		else if(tank4.getReservedUser().equals(user)){
			tank4.removeContent();
		}
		else if(tank5.getReservedUser().equals(user)){
			tank5.removeContent();
		}
		else if(tank6.getReservedUser().equals(user)){
			tank6.removeContent();
		}
		else if(tank7.getReservedUser().equals(user)){
			tank7.removeContent();
		}
		else if(tank8.getReservedUser().equals(user)){
			tank8.removeContent();
		}
		else if(tank9.getReservedUser().equals(user)){
			tank9.removeContent();
		}
		else if(tank10.getReservedUser().equals(user)){
			tank10.removeContent();
		}
	}
	
	public void reserveTank1(String user) throws RemoteException {
		tank1.setReservedUser(user);
	}
	public void reserveTank2(String user) throws RemoteException {
		tank2.setReservedUser(user);
	}
	public void reserveTank3(String user) throws RemoteException {
		tank3.setReservedUser(user);
	}
	public void reserveTank4(String user) throws RemoteException {
		tank4.setReservedUser(user);
	}
	public void reserveTank5(String user) throws RemoteException {
		tank5.setReservedUser(user);
	}
	public void reserveTank6(String user) throws RemoteException {
		tank6.setReservedUser(user);
	}
	public void reserveTank7(String user) throws RemoteException {
		tank7.setReservedUser(user);
	}
	public void reserveTank8(String user) throws RemoteException {
		tank8.setReservedUser(user);
	}
	public void reserveTank9(String user) throws RemoteException {
		tank9.setReservedUser(user);
	}
	public void reserveTank10(String user) throws RemoteException {
		tank10.setReservedUser(user);
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
