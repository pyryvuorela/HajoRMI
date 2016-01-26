
public class Pump implements Runnable{
	private final int PUMPSPEED = 500;
	private String currentUser;
	private int movedAmount;
	private boolean isUsed;
	
	private Tank usedTank;
	
	public Pump(){
		movedAmount = 0;
		isUsed = false;
	}
	
	public void run() {
		if(!isUsed){
			isUsed = true;
		try {
			System.out.println("Pumping started!");
			int sleepTime = 1000*(movedAmount/PUMPSPEED);
			Thread.sleep(sleepTime);
			usedTank.setCurrentAmount(movedAmount);
			System.out.println("Pump moved " + movedAmount + "kg!");
			isUsed = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}else{
			System.out.println("Pump is already used!");
		}
	}	
	public void setTank(Tank tank){
		this.usedTank = tank;
	}
	public void setMovedAmount(int amount){
		this.movedAmount = amount;
	}

}
