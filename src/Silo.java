
public class Silo extends Thread {
	private String user;
	private boolean isUsed;
	private int currentAmount;
	private SiloLoader siloLoader;
	private final int capacity = 10000;
	
	
	public Silo(String user, SiloLoader siloloader){
		this.user = user;
		this.siloLoader = siloloader;
		isUsed = false;
	}

	public void run(){
		if(!isUsed){
			isUsed=true;
			if(!siloLoader.getSiloLoaderState() && siloLoader.getIsReady()){
				System.out.println("Siloloader is reserved for this silo!");
				try {
					siloLoader.setSiloLoaderState(true);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Silo if full!");
				currentAmount = capacity;
				siloLoader.setSiloLoaderState(false);
			}
			isUsed = false;
		}
		System.out.println("Silo in not free for use!");
		
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
}
