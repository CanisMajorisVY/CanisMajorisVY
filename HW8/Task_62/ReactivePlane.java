public class ReactivePlane extends Plane {
	
	ReactivePlane() {
		
	}
	
	ReactivePlane(int numberOfEngines, int numberOfVings, String planeType) {
		this.numberOfEngines = numberOfEngines;
		this.numberOfVings = numberOfVings;
		this.planeType = planeType;
	}
	
	public void turnEnginesOn(){
		System.out.println("shhhhhhhhheeee");
	}
	public void turnEnginesOff(){
		System.out.println("pjsshhuuuuuu");
	}
	public void takeOff(){
		System.out.println("rrrrrrsrsr .. ssss");
	}
	
}