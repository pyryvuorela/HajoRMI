public class SiloLoader extends Thread{	
	
	private boolean isUsed;
	private boolean isReadyForUse;
	private Silo currentSilo;
	
	public SiloLoader() {
		isUsed = false;
	}

	@Override
	public void run() {
		isReadyForUse= true;
		isUsed = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(!isUsed)
			isReadyForUse = false;
	}
	public boolean getSiloLoaderState(){
		return isUsed;
	}
	public void setSiloLoaderState(boolean isused){
		isUsed = isused;
	}
	public boolean getIsReady(){
		return isReadyForUse;
	}
}
