public class SiloLoader implements Runnable{
	private String currentUser;
	private boolean loaderIsUsed;
	
	public SiloLoader() {
		currentUser = null;
		loaderIsUsed = false;
	}

	public void run() {

		if(currentUser != null){
			if(!loaderIsUsed){
				loaderIsUsed = true;
				try{
					System.out.println("Kuljetin pumppaa 200 kg/s");
					Thread.sleep(10000);
					currentUser = null;
					loaderIsUsed = false;
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
		return currentUser;
	}

	public void setCurrentUser(String user) {
		if(currentUser == null)
		this.currentUser = user;
		else
			System.out.println("Loader is already in use by user: " + currentUser);
		}
	public boolean getLoaderisUsed(){
		return loaderIsUsed;
	}
}
