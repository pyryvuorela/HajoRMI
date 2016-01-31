
public class BottlePump implements Runnable {

	private final int PUMPSPEED = 500;
	private int movedAmount;
	private boolean isUsed;

	
	public BottlePump(){
		movedAmount = 0;
		isUsed = false;
	}
	
	public void run() {
		if(!isUsed){
			isUsed = true;
		try {
			System.out.println("Pumping to bottles started!");
			while(movedAmount > 0){
				movedAmount -= 5;
				Thread.sleep(10);			
			}
			isUsed = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}else{
			System.out.println("Pump is already used!");
		}
	}	
	public void setMovedAmount(int amount){
		this.movedAmount = amount;
	}
}
