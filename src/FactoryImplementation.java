

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FactoryImplementation extends UnicastRemoteObject implements Factory {	
		private ArrayList<newUser> users;
		private newUser currentUser;
		private int numberOfUsers;
		
	public FactoryImplementation() throws RemoteException {	
		super();
		numberOfUsers = 0;
	}
	public void createNewUser(String name) throws RemoteException {		
		newUser newuser = new newUser(name);
		users.add(newuser);
		numberOfUsers++;
		setCurrentUser(newuser);
		
	}
	@Override
	public void userLogIn(String userName) throws RemoteException {
		if(numberOfUsers == 0){
			createNewUser(userName);
		}else if(numberOfUsers > 0){
			for(int i = 0; i < numberOfUsers; i++){
				if(users.get(i).getName().equals(userName)){
					setCurrentUser(users.get(i));
					System.out.println(userName + " logged in!");
				}
			}
		}else{
				createNewUser(userName);
			}				
		}		
	public newUser getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(newUser currentUser) {
		this.currentUser = currentUser;
	}
	public void startSiloLoadAction() throws RemoteException {
		
		
	}
	@Override
	public boolean reserveSilo1() throws RemoteException {
		return false;
		
	}

}
