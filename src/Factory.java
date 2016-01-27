

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factory extends Remote {

	public void userLogIn(String userName) throws RemoteException;
	
	public void startSiloLoadAction(String user) throws RemoteException;
	
	public void reserveSilo1(String user) throws RemoteException;
	public void reserveSilo2(String user) throws RemoteException;
	public void reserveSilo3(String user) throws RemoteException;
	public void reserveSilo4(String user) throws RemoteException;

	public void reserveStove1(String user) throws RemoteException;
	public void reserveStove2(String user) throws RemoteException;
	public void reserveStove3(String user) throws RemoteException;
	public void startStove1(String user) throws RemoteException;
	public void startStove2(String user) throws RemoteException;
	public void startStove3(String user) throws RemoteException;
	
	public void startUnloader1(int amount, String user) throws RemoteException;
	public void startUnloader2(int amount, String user) throws RemoteException;

	public void startPump1(String user) throws RemoteException;
	public void startPump2(String user) throws RemoteException;
	
	public void reserveTank1(String user) throws RemoteException;
	public void reserveTank2(String user) throws RemoteException;
	public void reserveTank3(String user) throws RemoteException;
	public void reserveTank4(String user) throws RemoteException;
	public void reserveTank5(String user) throws RemoteException;
	public void reserveTank6(String user) throws RemoteException;
	public void reserveTank7(String user) throws RemoteException;
	public void reserveTank8(String user) throws RemoteException;
	public void reserveTank9(String user) throws RemoteException;
	public void reserveTank10(String user) throws RemoteException;
	
	
	//UPDATER

	public String silo1CurrentAmountUpdate() throws RemoteException;
	public String silo2CurrentAmountUpdate() throws RemoteException;
	public String silo3CurrentAmountUpdate() throws RemoteException;
	public String silo4CurrentAmountUpdate() throws RemoteException;

	public String proc1CurrentUpdate() throws RemoteException;
	public String proc2CurrentUpdate() throws RemoteException;
	public String proc3CurrentUpdate() throws RemoteException;

	public boolean stove1GetStartPressed() throws RemoteException;
	public boolean stove2GetStartPressed() throws RemoteException;
	public boolean stove3GetStartPressed() throws RemoteException;
	
	public String proc1CurrentBatchUpdate() throws RemoteException;
	public String proc2CurrentBatchUpdate() throws RemoteException;
	public String proc3CurrentBatchUpdate() throws RemoteException;


	
}
