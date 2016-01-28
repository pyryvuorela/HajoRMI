
public class Tank implements Runnable{
	private final int MAXCAPACITY = 10000;
	private int currentAmount;
	private int incomingAmount;
	private boolean tankReadyToUse;
	private boolean receiving;
	private String reservedUser;

	public Tank(){
		this.currentAmount = 0;
		tankReadyToUse = true;
		receiving = true;
		reservedUser = "";
	}
	public void run() {
		if(receiving){
			while(currentAmount < MAXCAPACITY){
				currentAmount += 2;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Tanks current amount is: " + currentAmount);
		}else if (!receiving){
			while(currentAmount > 0){
				currentAmount -= 2;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Tanks current amount is: " + currentAmount);
			reservedUser = "";
		}		
	}
	

	public int getCurrentAmount(){
		return currentAmount;
	}
	public void setInmcomingAmount(int incoming){
		this.incomingAmount = incoming;
	}
	public void setReceiving(boolean r){
		this.receiving = r;
	}
	public boolean getTankState(){
		return tankReadyToUse;
	}
	public String getReservedUser() {
		return reservedUser;
	}
	public void setReservedUser(String user) {
		if(reservedUser == ""){
		this.reservedUser = user;
		System.out.println("Tank is reserved for user: " + reservedUser);
		}else{
			System.out.println("Tanks is already reserved!");
		}
	}
	public int removeContent(){
		int content = currentAmount;
		currentAmount = 0;
		return content;
		
	}


	

}
