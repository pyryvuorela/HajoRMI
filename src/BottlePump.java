
public class BottlePump implements Runnable {

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
		} catch (Exception e) {
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
