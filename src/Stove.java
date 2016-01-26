
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentWater;
	private int currentMaterial;
	private int currentBatch;
	private String reservedUser;
	private String currentUser;
	
	public Stove(){
	this.currentWater = 0;
	this.currentMaterial = 0;
	currentBatch = 0;
	reservedUser = null;
	}
	
	public void run() {
		if(reservedUser != null){
			if(reservedUser.equals(currentUser)){
			try {
				System.out.println("Stove is preparing the batch!");
				Thread.sleep(5000);
				currentBatch = currentMaterial *5;
				System.out.println("Batch is ready!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}else{
				System.out.println("Stove is not reserved for this user!");
			}
		}else{
			System.out.println("Stove is not reserved, please reserve Stove before use!");
		}
	}
	
	public void reserveStove(String user){
		reservedUser = user;
		System.out.println("Stove reserved for user: " + reservedUser);
	}
	public void setCurrentUser(String current){
		currentUser = current;
	}
	public String getReservedUser(){
		return reservedUser;
	}
	public void setMaterialAmount(int material){
		if(material + currentMaterial <= maxMaterialCapacity){
			int sleepTime = 1000*(material/200);
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		currentMaterial = material + currentMaterial;
		System.out.println("Material added! Current amount is: "+ currentMaterial);
		}		
		else
			System.out.println("Too much material!");
	}
	public int getCurrentBatch(){
		reservedUser = null;
		currentUser = null;
		return currentBatch;
	}


}
