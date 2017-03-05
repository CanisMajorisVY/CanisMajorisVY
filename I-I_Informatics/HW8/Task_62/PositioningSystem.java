public abstract class PositioningSystem {
	protected int x = 0, y = 0; 	
	protected final int MAX = 1000;
	
	protected int[][] mem = new int[2][MAX];
	
	abstract public void savePosition();
	abstract public void showPosition();
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}