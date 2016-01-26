
public class Stove implements Runnable{
	private final int maxWaterCapacity = 10000;
	private final int maxMaterialCapacity = 2000;
	private int currentWater;
	private int currentMaterial;
	private String reservedUser;
	private String currentUser;
	
	public Stove(){
	this.currentWater = 0;
	this.currentMaterial = 0;
	reservedUser = null;
	}
	
	public void run() {
		if(reservedUser != null){
			if(reservedUser.equals(currentUser)){
			try {
				System.out.println("Stove is preparing the batch!");
				Thread.sleep(5000);
				System.out.println("Batch is ready!");
				reservedUser = null;
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
	public void currentUser(String current){
		currentUser = current;
	}
	public void setMaterialAmount(int material){
		if(material <= currentMaterial)
		currentMaterial = material;
		else
			System.out.println("Too much material!");
	}


}
