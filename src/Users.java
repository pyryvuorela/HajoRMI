import java.util.LinkedList;

public class Users{
	private LinkedList<String> allUsers;
	private String currentUser;
	private int reservedSilo; 

	
	public Users(){
		allUsers = new LinkedList<String>();
	}
	public void checkLogInRegisterStatus(String name){
		if(!allUsers.isEmpty()){
		for(int i = 0; i < allUsers.size(); i++){
			if(name.equals(allUsers.get(i))){
				currentUser = name;
				System.out.println("User: " + name + " logged in!");
				break;
			}else{
				newUser(name);
				currentUser = name;
				System.out.println("User: " + name + " registered and logged in!");
				break;
			}
		}
		}else{
			newUser(name);
			currentUser = name;
			System.out.println("User: " + name + " registered and logged in!");
		}
	}
	public void newUser(String name){
		allUsers.add(name);
	}
	public String getCurrentUser() {
		return currentUser;
	}

}
