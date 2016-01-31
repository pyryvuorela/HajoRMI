
public class Silo implements Runnable {
	private int currentAmount;
	private String currentUser;
	private String SiloName;
	private boolean isUsed;
	private final int capacity = 10000;
	
	
	public Silo(String sName){
		this.currentAmount = 0;
		this.currentUser = "";
		this.SiloName = sName;
		this.isUsed = false;
	}

	public void run(){
		if(this.currentUser != ""){
			isUsed = true;
					System.out.println("Siloloader is reserved for " + SiloName);
					try {
						while (this.currentAmount < this.capacity){
							Thread.sleep(10);
							this.currentAmount += 2;
						}
						System.out.println(SiloName + " is full!");
						isUsed = false;
						this.removeCurrentUser();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		}
		else
			System.out.println(SiloName + " is already in use!");
	}
	
	public void removeSilosContent(int amount){
		if(amount <= this.currentAmount && amount <= 2000 && isUsed == false){
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
			System.out.println(SiloName + " is reserved for user: " + user);
		}
		else
			System.out.println(SiloName + " is used by user: " + this.currentUser);
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
	public boolean getIsUsed(){
		return isUsed;
	}
	
}
