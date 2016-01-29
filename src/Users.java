import java.util.LinkedList;

public class Users{
	private LinkedList<String> allUsers;
	private String currentUser;

	
	public Users(){
		allUsers = new LinkedList<String>();
	}
	public void checkLogInRegisterStatus(String name){
		if(!allUsers.isEmpty()){
			boolean found = false;
		for(int i = 0; i < allUsers.size(); i++){
			if(name.equals(allUsers.get(i))){
				currentUser = name;
				System.out.println("User: " + name + " logged in!");
				found = true;
				break;
			}
		}
		if(!found){
			newUser(name);
			currentUser = name;
			System.out.println("User: " + name + " registered and logged in!");
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
