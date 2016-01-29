
public class Silo implements Runnable {
	private int currentAmount;
	private String currentUser;
	private final int capacity = 10000;
	
	
	public Silo(){
		this.currentAmount = 10;
		this.currentUser = "";
	}

	public void run(){
		if(this.currentUser != ""){
					System.out.println("Siloloader is reserved for this silo!");
					try {
						while (this.currentAmount < this.capacity){
							Thread.sleep(10);
							this.currentAmount += 2;
						}
						System.out.println("Silo is full!");
						this.removeCurrentUser();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		}
		else
			System.out.println("Silo is already in use!");
	}
	
	public void removeSilosContent(int amount){
		if(amount <= this.currentAmount && amount <= 2000){
		this.currentAmount -= amount;
		this.currentUser = "";
		}
		else
			System.out.println("Not enought content!");
	}
	public int getCurrentAmount(){
		return this.currentAmount;
	}
	public void setCurrentUser(String user){
		if(this.currentUser == ""){
			this.currentUser = user;
			System.out.println("Silo is reserved for user: " + user);
		}
		else
			System.out.println("Silo is used by user: " + this.currentUser);
	}
	public String getCurrentUser(){
		return this.currentUser;		
	}
	public void removeCurrentUser(){
		this.currentUser = "";
	}
	public int getCapacity(){
		return this.capacity;
	}
	
}
