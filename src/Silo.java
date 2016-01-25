
public class Silo implements Runnable {
	private int currentAmount;
	private final int capacity = 10000;
	
	
	public Silo(){
		currentAmount = 10;
	}

	public void run(){
					System.out.println("Siloloader is reserved for this silo!");
					try {
						Thread.sleep(5000);
						currentAmount = capacity;
						System.out.println("Silo is full!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
	
	public void removeSilosContent(int amount){
		if(amount > currentAmount)
		currentAmount -= amount;
		else
			System.out.println("Not enought content!");
	}
	public int getCurrentAmount(){
		return currentAmount;
	}
}
