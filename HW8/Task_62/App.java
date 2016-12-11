public class App {
	public static void main (String[] args) {
		
		GPS navigation = new GPS();
		ReactivePlane F22 = new ReactivePlane(2, 2, "Fighter");
		
		F22.turnEnginesOn();
		
		for (int i = 0; i < 10; i++) {
			navigation.setPosition(i, 10-i);
			navigation.savePosition();
		}
		
		navigation.showPath();
	}
}