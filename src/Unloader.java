
public class Unloader implements Runnable {
	private int unloadAmount;
	private final int maxUnload = 2000;
	private final int maxUnloadSpeed = 200;
	private String user;

	public Unloader(){
		
		
	}
	public void run() {
		
	}
	
	public void setUnloadAmount(int amount){
		unloadAmount = amount;
	}
	public void setUser(String user){
		this.user = user;
	}

	
}
