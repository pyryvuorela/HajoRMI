
public class newUser {
	private String name;
	private boolean siloLoading;
	private int siloIndex;

	public newUser(String name) {
		this.name = name;
	}

	public int getSiloIndex() {
		return siloIndex;
	}

	public void setSiloIndex(int siloIndex) {
		this.siloIndex = siloIndex;
	}

	public boolean isSiloLoading() {
		return siloLoading;
	}

	public void setSiloLoading(boolean siloLoading) {
		this.siloLoading = siloLoading;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
