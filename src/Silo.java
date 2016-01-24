
public class Silo implements Runnable {
	private String user;
	private boolean isUsed;
	private int currentAmount;
	private SiloLoader siloLoader;
	private final int capacity = 10000;
	private volatile boolean shutdown;
	
	
	public Silo(String user, SiloLoader siloloader){
		this.user = user;
		this.siloLoader = siloloader;
		isUsed = false;
		shutdown = false;
	}

	public void run(){
		while(shutdown == false){
			if(!isUsed){
				isUsed=true;
				if(!siloLoader.getSiloLoaderState() && siloLoader.getIsReadyForUse()){
					System.out.println("Siloloader is reserved for this silo!");
					try {
						siloLoader.setSiloLoaderState(true);
						Thread.sleep(5000);
						shutdown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Silo is full!");
					currentAmount = capacity;
					
					siloLoader.setSiloLoaderState(false);
				}
				isUsed = false;
			}
		}
		
	}
	public boolean isSiloFree(){
		return isUsed;
	}
	public void removeSilosContent(int amount){
		if(amount > currentAmount)
		currentAmount -= amount;
		else
			System.out.println("Not enought content!");
	}
	public void shutdown(){
		shutdown = true;
	}
	public int getCurrentAmount(){
		return currentAmount;
	}
}
