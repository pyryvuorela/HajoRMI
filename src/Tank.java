
public class Tank implements Runnable{
	private final int MAXCAPACITY = 10000;
	private int currentAmount;
	private int incomingAmount;
	private boolean tankReadyToUse;
	private boolean receiving;
	private String reservedUser;

	public Tank(){
		this.currentAmount = 0;
		this.tankReadyToUse = true;
		this.receiving = true;
		this.reservedUser = "";
	}
	public void run() {
		if(this.receiving){
			while(this.currentAmount < this.incomingAmount){
				this.currentAmount += 2;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Tanks current amount is: " + this.currentAmount);
		}else if (!this.receiving){
			while(this.currentAmount > 0){
				this.currentAmount -= 2;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Tanks current amount is: " + this.currentAmount);
			this.reservedUser = "";
		}		
	}
	

	public int getCurrentAmount(){
		return this.currentAmount;
	}
	public void setInmcomingAmount(int incoming){
		this.incomingAmount = incoming;
	}
	public void setReceiving(boolean r){
		this.receiving = r;
	}
	public boolean getTankState(){
		return this.tankReadyToUse;
	}
	public String getReservedUser() {
		return this.reservedUser;
	}
	public void setReservedUser(String user) {
		if(this.reservedUser == ""){
		this.reservedUser = user;
		System.out.println("Tank is reserved for user: " + this.reservedUser);
		}else{
			System.out.println("Tanks is already reserved!");
		}
	}
	public int removeContent(){
		int content = currentAmount;
		this.currentAmount = 0;
		return content;
		
	}


	

}
