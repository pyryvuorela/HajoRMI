
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentMaterial;
	private int incomingMaterial;
	private int currentBatch;
	private String reservedUser;
	private boolean startPressed;
	private boolean batching; 
	private boolean isUsed;
	
	private String StoveName;
	
	public Stove(String Sname){
	this.currentMaterial = 0;
	this.currentBatch = 0;
	this.reservedUser = "";
	this.startPressed = false;
	this.batching = false;
	this.isUsed = false;
	this.StoveName = Sname;
	}
	
	public void run() { 
		if(batching){
			if(this.reservedUser != ""){
					this.startPressed = true;
					isUsed = true;
					try {
						System.out.println("Stove is preparing the batch!");
						currentBatch = currentMaterial;
						int materialX5temp = currentMaterial * 5;
						while (this.currentBatch < materialX5temp){
							Thread.sleep(10);
							this.currentBatch += 2;
							this.currentMaterial += 2;
						}
						System.out.println("Batch is ready!");
						batching = false;
						isUsed = false;
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else{
				System.out.println("Stove is not reserved, please reserve Stove before use!");
			}
		}else if(!batching){
				try {
					isUsed = true;
					while (this.currentMaterial < incomingMaterial){				
						Thread.sleep(10);
						currentMaterial+=2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			System.out.println("Material added! Current amount is: "+ this.currentMaterial);
			batching = true;
			isUsed = false;
		}		
	}
	
	public void reserveStove(String user){
		if(this.reservedUser == ""){
			this.startPressed = false;
			this.reservedUser = user;
			System.out.println(StoveName +" is reserved for user: " + this.reservedUser);
		}else{
			System.out.println("Stove is already in use!");
		}
	}

	public String getReservedUser(){
		return this.reservedUser;
	}
	public void setBatching(boolean b){
		this.batching = b;
	}
	public boolean getBatchingBool(){
		return batching;
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
	public int getCurrentBatch(int tankCurrent){
		int removeC = this.currentBatch;
		if(10000 >= tankCurrent + currentBatch){
			this.reservedUser = "";
			removeC = currentBatch + tankCurrent;
			currentBatch = 0;
			currentMaterial = 0;
			return removeC;
		}else{
			removeC = 10000 - tankCurrent;
			this.currentBatch -= removeC;
			this.currentMaterial -= removeC;
			return removeC;
		}
	}
	public int getCurrentBatchWithoutRemove(){
		return this.currentBatch;
	}
	public boolean getIsUsed(){
		return isUsed;
	}
}
