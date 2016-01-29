

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
		this.stove1 =  new Stove("Stove1");
		this.stove2 =  new Stove("Stove2");
		this.stove3 =  new Stove("Stove3");
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
		this.Bpump1 = new BottlePump();
		this.Bpump2 = new BottlePump();

		
	}

	public void userLogIn(String userName) throws RemoteException {
		users.checkLogInRegisterStatus(userName);
	}
	public void startSiloLoadAction(String user) throws RemoteException {
		if(silo1.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo1.getCapacity() - silo1.getCurrentAmount()));
					new Thread(siloLoader).start();
					new Thread(silo1).start();
			}
		}
		 else if(silo2.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo2.getCapacity() - silo2.getCurrentAmount()));
					new Thread(siloLoader).start();
					new Thread(silo2).start();
				}
		}
		 else if(silo3.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo3.getCapacity() - silo3.getCurrentAmount()));
					new Thread(siloLoader).start();
					new Thread(silo3).start();
				}
		}
		 else if(silo4.getCurrentUser().equals(user)){
			siloLoader.setCurrentUser(user);
				if(!siloLoader.getLoaderisUsed()){
					siloLoader.setLoadTime((silo4.getCapacity() - silo4.getCurrentAmount()));
					new Thread(siloLoader).start();
					new Thread(silo4).start();
				}
		}
		 else {
			 System.out.println("Please recerve silo before using Siloloader!");
		 }
	}
	public void reserveSilo1(String user) throws RemoteException {
			silo1.setCurrentUser(user);
	}
	public void reserveSilo2(String user) throws RemoteException {
			silo2.setCurrentUser(user);
	}
	public void reserveSilo3(String user) throws RemoteException {
			silo3.setCurrentUser(user);
	}
	public void reserveSilo4(String user) throws RemoteException {
			silo4.setCurrentUser(user);
	}
	public void reserveStove1(String user) throws RemoteException {
		stove1.reserveStove(user);
	}
	public void reserveStove2(String user) throws RemoteException {
		stove2.reserveStove(user);
	}
	public void reserveStove3(String user) throws RemoteException {
		stove3.reserveStove(user);
	}
	public void startStove1(String user) throws RemoteException {
		if(stove1.getReservedUser().equals(user)){
			stove1.setBatching(true);
			new Thread(stove1).start();
		}else{
			System.out.println("You have no recervation for this stove!");
		}
	}
	public void startStove2(String user) throws RemoteException {
		if(stove2.getReservedUser().equals(user)){
			stove2.setBatching(true);
			new Thread(stove2).start();
		}else{
			System.out.println("You have no recervation for this stove!");
		}
	}
	public void startStove3(String user) throws RemoteException {
		if(stove3.getReservedUser().equals(user)){
			stove3.setBatching(true);
			new Thread(stove3).start();
		}else{
			System.out.println("You have no recervation for this stove!");
		}
	}
	
	public void startUnloader1(int amount, String user) throws RemoteException {
		if(!unloader1.isUsed()){
			unloader1.setUnloadAmount(amount);
			new Thread(unloader1).start();
		if(silo1.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo2.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo3.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo4.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		}else{
			System.out.println("Unloader is already in use!");
		}
	}
	public void startUnloader2(int amount, String user) throws RemoteException {
		if(!unloader2.isUsed()){
			unloader2.setUnloadAmount(amount);
			new Thread(unloader2).start();
		if(silo1.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo1.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo2.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo2.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo3.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo3.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		else if(silo4.getCurrentUser().equals(user)){
			if(stove1.getReservedUser().equals(user) && stove1.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove1.setMaterialAmount(amount);
				stove1.setBatching(false);
				new Thread(stove1).start();
			}			
			else if(stove2.getReservedUser().equals(user) && stove2.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove2.setMaterialAmount(amount);
				stove2.setBatching(false);
				new Thread(stove2).start();
			}
			else if(stove3.getReservedUser().equals(user) && stove3.getCurrentMaterial() + amount <= 2000){
				silo4.removeSilosContent(amount);		
				stove3.setMaterialAmount(amount);
				stove3.setBatching(false);
				new Thread(stove3).start();
			}
		}
		}else{
			System.out.println("Unloader is already in use!");
		}
	}

	public void startPump1(String user) throws RemoteException {
		if(!pump1.getIsUsed()){			
			if(stove1.getReservedUser().equals(user)){
				pump1.setMovedAmount(stove1.getCurrentBatchWithoutRemove());
				new Thread(pump1).start();
			
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();
				}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();			
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();
					}
			}
			else if(stove2.getReservedUser().equals(user)){
				pump1.setMovedAmount(stove2.getCurrentBatchWithoutRemove());
				new Thread(pump1).start();
				
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();
					}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();	
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();	
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();	
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();	
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();	
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();	
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();	
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();	
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();	
					}	
			}
			else if(stove3.getReservedUser().equals(user)){
				pump1.setMovedAmount(stove3.getCurrentBatchWithoutRemove());
				new Thread(pump1).start();
				
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();	
					}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();	
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();	
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();	
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();	
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();	
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();	
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();	
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();	
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();	
					}	
			}
		}else{
			System.out.println("Pump 1 is already in use!");
		}
	}
	public void startPump2(String user) throws RemoteException {
		if(!pump2.getIsUsed()){
			if(stove1.getReservedUser().equals(user)){
				pump2.setMovedAmount(stove1.getCurrentBatchWithoutRemove());
				new Thread(pump2).start();
				
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();
				}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();			
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();
					}
			}
			else if(stove2.getReservedUser().equals(user)){
				pump2.setMovedAmount(stove2.getCurrentBatchWithoutRemove());
				new Thread(pump2).start();
				
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();
					}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();	
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();	
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();	
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();	
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();	
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();	
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();	
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();	
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();	
					}	
			}
			else if(stove3.getReservedUser().equals(user)){
				pump2.setMovedAmount(stove3.getCurrentBatchWithoutRemove());
				new Thread(pump2).start();
				
				if(tank1.getReservedUser().equals(user)){
					tank1.setInmcomingAmount(stove1.getCurrentBatch(tank1.getCurrentAmount()));
					tank1.setReceiving(true);
					new Thread(tank1).start();	
					}	
				else if(tank2.getReservedUser().equals(user)){
					tank2.setInmcomingAmount(stove1.getCurrentBatch(tank2.getCurrentAmount()));
					tank2.setReceiving(true);
					new Thread(tank2).start();	
					}
				else if(tank3.getReservedUser().equals(user)){
					tank3.setInmcomingAmount(stove1.getCurrentBatch(tank3.getCurrentAmount()));
					tank3.setReceiving(true);
					new Thread(tank3).start();	
					}
				else if(tank4.getReservedUser().equals(user)){
					tank4.setInmcomingAmount(stove1.getCurrentBatch(tank4.getCurrentAmount()));
					tank4.setReceiving(true);
					new Thread(tank4).start();	
					}
				else if(tank5.getReservedUser().equals(user)){
					tank5.setInmcomingAmount(stove1.getCurrentBatch(tank5.getCurrentAmount()));
					tank5.setReceiving(true);
					new Thread(tank5).start();	
					}
				else if(tank6.getReservedUser().equals(user)){
					tank6.setInmcomingAmount(stove1.getCurrentBatch(tank6.getCurrentAmount()));
					tank6.setReceiving(true);
					new Thread(tank6).start();	
					}
				else if(tank7.getReservedUser().equals(user)){
					tank7.setInmcomingAmount(stove1.getCurrentBatch(tank7.getCurrentAmount()));
					tank7.setReceiving(true);
					new Thread(tank7).start();	
					}
				else if(tank8.getReservedUser().equals(user)){
					tank8.setInmcomingAmount(stove1.getCurrentBatch(tank8.getCurrentAmount()));
					tank8.setReceiving(true);
					new Thread(tank8).start();	
					}
				else if(tank9.getReservedUser().equals(user)){
					tank9.setInmcomingAmount(stove1.getCurrentBatch(tank9.getCurrentAmount()));
					tank9.setReceiving(true);
					new Thread(tank9).start();	
					}
				else if(tank10.getReservedUser().equals(user)){
					tank10.setInmcomingAmount(stove1.getCurrentBatch(tank10.getCurrentAmount()));
					tank10.setReceiving(true);
					new Thread(tank10).start();	
					}	
			}
			}else{
				System.out.println("Pump 2 is already in use!");
			}
	}
	public void startBottlePump1(String user) throws RemoteException {
		if(tank1.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank1.setReceiving(false);
			new Thread(tank1).start();
			new Thread(Bpump1).start();
		}	
		else if(tank2.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank2.setReceiving(false);
			new Thread(tank2).start();
			new Thread(Bpump1).start();
			}
		else if(tank3.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank3.setReceiving(false);
			new Thread(tank3).start();
			new Thread(Bpump1).start();
			}
		else if(tank4.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank4.setReceiving(false);
			new Thread(tank4).start();
			new Thread(Bpump1).start();
			}
		else if(tank5.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank5.setReceiving(false);
			new Thread(tank5).start();
			new Thread(Bpump1).start();
			}
		else if(tank6.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank6.setReceiving(false);
			new Thread(tank6).start();
			new Thread(Bpump1).start();
			}
		else if(tank7.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank7.setReceiving(false);
			new Thread(tank7).start();
			new Thread(Bpump1).start();
			}
		else if(tank8.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank8.setReceiving(false);
			new Thread(tank8).start();
			new Thread(Bpump1).start();
			}
		else if(tank9.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank9.setReceiving(false);
			new Thread(tank9).start();
			new Thread(Bpump1).start();
			}
		else if(tank10.getReservedUser().equals(user)){
			Bpump1.setMovedAmount(tank1.getCurrentAmount());
			tank10.setReceiving(false);
			new Thread(tank10).start();
			new Thread(Bpump1).start();
			}	
		}	

	public void startBottlePump2(String user) throws RemoteException {		
		if(tank1.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank1.setReceiving(false);
			new Thread(tank1).start();
			new Thread(Bpump2).start();
		}	
		else if(tank2.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank2.setReceiving(false);
			new Thread(tank2).start();
			new Thread(Bpump2).start();
			}
		else if(tank3.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank3.setReceiving(false);
			new Thread(tank3).start();
			new Thread(Bpump2).start();
			}
		else if(tank4.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank4.setReceiving(false);
			new Thread(tank4).start();
			new Thread(Bpump2).start();
			}
		else if(tank5.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank5.setReceiving(false);
			new Thread(tank5).start();
			new Thread(Bpump2).start();
			}
		else if(tank6.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank6.setReceiving(false);
			new Thread(tank6).start();
			new Thread(Bpump2).start();
			}
		else if(tank7.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank7.setReceiving(false);
			new Thread(tank7).start();
			new Thread(Bpump2).start();
			}
		else if(tank8.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank8.setReceiving(false);
			new Thread(tank8).start();
			new Thread(Bpump2).start();
			}
		else if(tank9.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank9.setReceiving(false);
			new Thread(tank9).start();
			new Thread(Bpump2).start();
			}
		else if(tank10.getReservedUser().equals(user)){
			Bpump2.setMovedAmount(tank1.getCurrentAmount());
			tank10.setReceiving(false);
			new Thread(tank10).start();
			new Thread(Bpump2).start();
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
	
	public String tank1CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank1.getCurrentAmount());
	}
	public String tank2CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank2.getCurrentAmount());
	}
	public String tank3CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank3.getCurrentAmount());
	}
	public String tank4CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank4.getCurrentAmount());
	}
	public String tank5CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank5.getCurrentAmount());
	}
	public String tank6CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank6.getCurrentAmount());
	}
	public String tank7CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank7.getCurrentAmount());
	}
	public String tank8CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank8.getCurrentAmount());
	}
	public String tank9CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank9.getCurrentAmount());
	}
	public String tank10CurrentAmountUpdate() throws RemoteException {
		return Integer.toString(tank10.getCurrentAmount());
	}

	public String stove1CurrentUserUpdate() throws RemoteException {
		return stove1.getReservedUser();
	}
	public String stove2CurrentUserUpdate() throws RemoteException {
		return stove2.getReservedUser();
	}
	public String stove3CurrentUserUpdate() throws RemoteException {
		return stove3.getReservedUser();
	}
}
