public abstract class Plane {
	protected int numberOfVings;
	protected int numberOfEngines;
	protected String planeType;
	
	abstract public void turnEnginesOn ();
	abstract public void turnEnginesOff ();
	abstract public void takeOff ();
	
	//-------------------------------------
	
	public void setNumberOfEngines (int x) {
		numberOfEngines = x;
	}
	public void setNumberOfVings (int x) {
		numberOfVings = x;
	}
	public void setplaneType (String x) {
		planeType = x;
	}
	
	public int getNumberOfEngines() {
		return numberOfEngines;
	}
	public int getNumberOfVings() {
		return numberOfVings;
	}
	public String getPlaneType() {
		return planeType;
	}
	
}