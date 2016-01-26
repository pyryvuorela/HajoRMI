
public class Tank{
	private final int MAXCAPACITY = 10000;
	private int currentAmount;
	private boolean tankReadyToUse;
	private String reservedUser;

	public Tank(){
		this.currentAmount = 0;
		tankReadyToUse = true;
		reservedUser = null;
	}

	public int getCurrentAmount(){
		return currentAmount;
	}
	public void setCurrentAmount(int current){
		currentAmount = current;
		System.out.println("Tanks current amount is: " + currentAmount);
	}
	public boolean getTankState(){
		return tankReadyToUse;
	}
	public String getReservedUser() {
		return reservedUser;
	}
	public void setReservedUser(String user) {
		if(reservedUser == null){
		this.reservedUser = user;
		System.out.println("Tank is reserved for user: " + reservedUser);
		}else{
			System.out.println("Tanks is already reserved!");
		}
	}
	
	

}
