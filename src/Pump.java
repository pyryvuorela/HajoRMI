
public class Pump implements Runnable{
	private final int PUMPSPEED = 500;
	private int movedAmount;
	private boolean isUsed;

	
	public Pump(){
		movedAmount = 0;
		isUsed = false;
	}
	
	public void run() {
		if(!isUsed){
			isUsed = true;
			System.out.println("Pump is in action!");
			while(movedAmount > 0){
				movedAmount -= 5;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		isUsed = false;
		System.out.println("Pump is ready for use!");
		}
	}	
	public void setMovedAmount(int amount){
		this.movedAmount = amount;
	}
	public boolean getIsUsed(){
		return isUsed;
	}

}
