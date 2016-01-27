
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentWater;
	private int currentMaterial;
	private int currentBatch;
	private String reservedUser;
	private String currentUser;
	private boolean startPressed;
	
	public Stove(){
	this.currentWater = 0;
	this.currentMaterial = 0;
	currentBatch = 0;
	reservedUser = null;
	this.startPressed = false;
	}
	
	public void run() { 
		if(reservedUser != null){
			if(reservedUser.equals(currentUser)){
				startPressed = true;
			try {
				System.out.println("Stove is preparing the batch!");
				while (currentBatch < currentMaterial * 5){
					Thread.sleep(1);
					currentBatch += 2;
					// Testauksen takia
					System.out.println(currentBatch);
				}
				
				//Thread.sleep(5000);
				//currentBatch = currentMaterial * 5;
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
		if(reservedUser == null){
			startPressed = false;
			reservedUser = user;
			System.out.println("Stove reserved for user: " + reservedUser);
		}else{
			System.out.println("Stove is already in use!");
		}
	}
	public void setCurrentUser(String current){
		currentUser = current;
	}
	public String getReservedUser(){
		return reservedUser;
	}
	public void setMaterialAmount(int material){
		if(material + currentMaterial <= maxMaterialCapacity){
			//int sleepTime = 1000*(material/200);
			int oldCurrentMaterial = currentMaterial;
			try {
				while (currentMaterial < material + oldCurrentMaterial){					
					Thread.sleep(1);
					currentMaterial = currentMaterial + 1;
					// Testauksen takia
					System.out.println(currentMaterial);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("Material added! Current amount is: "+ currentMaterial);
		}		
		else
			System.out.println("Too much material!");
	}
	public int getCurrentMaterial(){
		return currentMaterial;
	}
	public boolean getStartPressed(){
		return startPressed;
	}
	public int getCurrentBatch(){
		reservedUser = null;
		currentUser = null;
		return currentBatch;
	}


}
