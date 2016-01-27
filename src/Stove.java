
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
	this.currentBatch = 0;
	this.reservedUser = "";
	this.startPressed = false;
	}
	
	public void run() { 
		if(this.reservedUser != ""){
			if(this.reservedUser.equals(this.currentUser)){
				this.startPressed = true;
			try {
				System.out.println("Stove is preparing the batch!");
				while (this.currentBatch < this.currentMaterial * 5){
					Thread.sleep(1);
					this.currentBatch += 2;
					// Testauksen takia
					System.out.println(this.currentBatch);
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
		if(this.reservedUser == ""){
			this.startPressed = false;
			this.reservedUser = user;
			System.out.println("Stove reserved for user: " + this.reservedUser);
		}else{
			System.out.println("Stove is already in use!");
		}
	}
	public void setCurrentUser(String current){
		this.currentUser = current;
	}
	public String getReservedUser(){
		return this.reservedUser;
	}
	public void setMaterialAmount(int material){
		if(material + this.currentMaterial <= this.maxMaterialCapacity){
			//int sleepTime = 1000*(material/200);
			int oldCurrentMaterial = this.currentMaterial;
			try {
				while (this.currentMaterial < material + oldCurrentMaterial){					
					Thread.sleep(1);
					this.currentMaterial = this.currentMaterial + 1;
					// Testauksen takia
					System.out.println(this.currentMaterial);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("Material added! Current amount is: "+ this.currentMaterial);
		}		
		else
			System.out.println("Too much material!");
	}
	public int getCurrentMaterial(){
		return this.currentMaterial;
	}
	public boolean getStartPressed(){
		return this.startPressed;
	}
	public int getCurrentBatch(){
		this.reservedUser = "";
		this.currentUser = "";
		return this.currentBatch;
	}


}
