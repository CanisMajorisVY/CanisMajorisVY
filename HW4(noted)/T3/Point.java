class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void setX(int x2){
		x = x2;
	}
	
	void setY(int y2){
		y = y2;
	}
	
	int getX () {
		return x;
	}
	
	int getY () {
		return y;
	}
	
	String getXY () {
		return ("(" + x + "; " + y + ")");
	}
	
	
}