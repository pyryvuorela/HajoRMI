
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentMaterial;
	private int incomingMaterial;
	private int currentBatch;
	private String reservedUser;
	private String currentUser;
	private boolean startPressed;
	private boolean batching;
	
	public Stove(){
	this.currentMaterial = 0;
	this.currentBatch = 0;
	this.reservedUser = "";
	this.startPressed = false;
	this.batching = false;
	}
	
	public void run() { 
		if(batching){
			if(this.reservedUser != ""){
				if(this.reservedUser.equals(this.currentUser)){
					this.startPressed = true;
					try {
						System.out.println("Stove is preparing the batch!");
						while (this.currentBatch < this.currentMaterial * 5){
							Thread.sleep(1);
							this.currentBatch += 2;
						}
						System.out.println("Batch is ready!");
						batching = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Stove is not reserved for this user!");
				}
			}else{
				System.out.println("Stove is not reserved, please reserve Stove before use!");
			}
		}else if(!batching){
				try {
					while (this.currentMaterial < incomingMaterial){				
						Thread.sleep(1);
						currentMaterial+=2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			System.out.println("Material added! Current amount is: "+ this.currentMaterial);
			batching = true;
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
	public void setBatching(boolean b){
		batching = b;
	}
	public void setMaterialAmount(int material){
		if(material + this.currentMaterial <= this.maxMaterialCapacity){
			incomingMaterial = material;
		}
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
