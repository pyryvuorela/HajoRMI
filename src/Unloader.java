
public class Unloader implements Runnable {
	private int unloadAmount;
	private final int maxUnload = 2000;
	private final int maxUnloadSpeed = 200;
	private String user;
	private boolean unloaderDone;

	public Unloader(){
		unloaderDone = false;
		
	}
	public void run() {

	}
	
	public void setUnloadAmount(int amount){
		unloaderDone = false;
		unloadAmount = amount;
	}
	public void setUser(String user){
		this.user = user;
	}
	public boolean getUnloaderDone(){
		return unloaderDone;
	}

	
}
