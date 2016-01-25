
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentWater;
	private int currentMaterial;
	private String currentUser;
	
	public Stove(){
	this.currentWater = 0;
	this.currentMaterial = 0;
	}
	
	public void run() {
			try {
				System.out.println("Stove is preparing the batch!");
				Thread.sleep(5000);
				System.out.println("Batch is ready!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
	}
	
	public void reserveStove(String user){
		currentUser = user;
		System.out.println("Stove reserved for user: " + currentUser);
	}
	public void setMaterialAmount(int material){
		if(material <= currentMaterial)
		currentMaterial = material;
		else
			System.out.println("Too much material!");
	}


}
