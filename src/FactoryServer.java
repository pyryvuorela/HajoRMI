

import java.rmi.Naming;

public class FactoryServer {

	public static void main(String[] q) {
		try {
			FactoryImplementation factory = new FactoryImplementation();
			Naming.rebind("factory", factory);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	} // main

} 