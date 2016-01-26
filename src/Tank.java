
public class Tank{
	private final int MAXCAPACITY = 10000;
	private int currentAmount;
	private String natureOfBewerage;
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
	}
	public boolean getTankState(){
		return tankReadyToUse;
	}
	public String getReservedUser() {
		return reservedUser;
	}
	public void setReservedUser(String reservedUser) {
		if(reservedUser == null)
		this.reservedUser = reservedUser;
		else
			System.out.println("Tanks is already reserved!");
	}
	
	

}
