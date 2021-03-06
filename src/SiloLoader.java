public class SiloLoader implements Runnable{
	private String currentUser;
	private boolean loaderIsUsed;
	private int loadTime;
	
	public SiloLoader() {
		this.currentUser = "";
		this.loaderIsUsed = false;
		this.loadTime = 0;
	}

	public void run() {
		if(this.currentUser != ""){
			if(!this.loaderIsUsed){
				this.loaderIsUsed = true;
				try{
					System.out.println("Siloloader is loading 200 kg/s.");
					Thread.sleep(loadTime*5);
					this.currentUser = "";
					this.loaderIsUsed = false;
					System.out.println("Siloloader is done!");
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			}
			else{
				System.out.println("Loader is already in use by user: " + currentUser);
			}
			}
		}

	public String getCurrentUser() {
		return this.currentUser;
	}
	public void setCurrentUser(String user) {
		if(this.currentUser == "")
		this.currentUser = user;
		else
			System.out.println("Loader is already in use by user: " + this.currentUser);
		}
	public boolean getLoaderisUsed(){
		return this.loaderIsUsed;
	}
	public void setLoadTime(int loadTime) {
		this.loadTime = loadTime;
	}
}
