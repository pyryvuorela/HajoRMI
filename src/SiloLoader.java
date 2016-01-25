public class SiloLoader implements Runnable{	
	
	
	
	public SiloLoader() {
	}

	@Override
	public void run() {
				try {
					System.out.println("Kuljetin pumppaa 200 kg/s");
					Thread.sleep(5000);
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			}

}
