
public class Silo implements Runnable {
	private int currentAmount;
	private String currentUser;
	private String loaderUser;
	private final int capacity = 10000;
	
	
	public Silo(){
		currentAmount = 10;
		currentUser = null;
	}

	public void run(){
		if(currentUser != null){
					System.out.println("Siloloader is reserved for this silo!");
					try {
						while (currentAmount < capacity){
							Thread.sleep(1);
							currentAmount = currentAmount + 2;
						}
						System.out.println("Silo is full!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		}
		else
			System.out.println("Silo is already in use!");
	}
	
	public void removeSilosContent(int amount){
		if(amount <= currentAmount && amount <= 2000){
		currentAmount -= amount;
		currentUser = null;
		}
		else
			System.out.println("Not enought content!");
	}
	public int getCurrentAmount(){
		return currentAmount;
	}
	public void setCurrentUser(String user){
		if(currentUser == null){
		currentUser = user;
		System.out.println("Silo is reserved for user: " + user);
		}
		else
			System.out.println("Silo is used by user: " + currentUser);
	}
	public String getCurrentUser(){
		return currentUser;		
	}
	
}
