public class SiloLoader implements Runnable{	
	
	private boolean isUsed;
	private boolean isReadyForUse;
	private Silo currentSilo;
	private volatile boolean shutdown;
	
	public SiloLoader() {
		isUsed = false;
		isReadyForUse = true;
		shutdown = false;
	}

	@Override
	public void run() {
		while(shutdown == false){
			if(isUsed == false){
				isReadyForUse = false;
				isUsed = true;
				try {
					System.out.println("Kuljetin pumppaa 200 kg/s");
					Thread.sleep(5000);
					System.out.println("Kuljetin pumppasi 1000 kg");
					shutdown();
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			}else{
				System.out.println("Kuljetin on jo kaytossa!");
			}
		}
		shutdown = false;
		isReadyForUse = true;
		isUsed = false;
	}
	public boolean getSiloLoaderState(){
		return isUsed;
	}
	public void setSiloLoaderState(boolean isused){
		isUsed = isused;
	}
	public boolean getIsReadyForUse(){
		return isReadyForUse;
	}
	public void shutdown(){
		shutdown = true;
	}
}
