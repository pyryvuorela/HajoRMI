
public class Unloader implements Runnable {
	private int unloadAmount;
	private String user;
	private boolean used;

	public Unloader(){
		used = false;		
	}
	
	public void run() {
		if(!used){
			used = true;
			System.out.println("Unloader is in use!");
			while(0 < unloadAmount){
				unloadAmount -= 2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			used = false;
			System.out.println("Unloader is ready");

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
