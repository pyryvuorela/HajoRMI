
public class Unloader implements Runnable {
	private int unloadAmount;
	private final int maxUnload = 2000;
	private final int maxUnloadSpeed = 200;
	private String user;
	private boolean used;

	public Unloader(){
		used = false;
		
	}
	public void run() {
		if(!used){
			used = true;
			int sleepTime = 0;
			while(sleepTime < unloadAmount){
				unloadAmount += 2;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			used = false;
		}
		else{
			System.out.println("Unloader is already in use for user: " + user);
		}

	}
	
	public void setUnloadAmount(int amount){
		unloadAmount = amount;
	}
	public void setUser(String user){
		this.user = user;
	}
	public boolean isUsed(){
		return used;
		
	}
}
