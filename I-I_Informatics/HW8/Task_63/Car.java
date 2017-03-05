public class Car implements AutopilotInterface, Beepable, Rideable {
	
	public void ride() {
		System.out.println("rrr..");
	}
	
	public void beep() {
		System.out.println("beeep");
	}
	
	public void autoRide() {
		System.out.println("rumrum..");
	}
	
	public void park() {
		System.out.println("rr,rr,rr,rum.");
	}


	
}