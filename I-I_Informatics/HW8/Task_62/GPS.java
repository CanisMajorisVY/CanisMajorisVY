public class GPS extends PositioningSystem {
	private int n = 0;
	
	GPS() {
		
	}
	
	public void savePosition() {
		if (n <= MAX) {
			mem[0][n] = x;
			mem[1][n] = y;
			n++;
		}
	}
	
	public void showPosition(){
		System.out.println(x + ", " + y);
	}
	
	public void showPath() {
		for (int i = 0; i < n; i++) {
			System.out.println(mem[0][i] + ", " + mem[1][i]);
		}
	}
	
}