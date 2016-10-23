public class App {
	
	public static void main(String[] args) {
		
		Array a = new Array();
		
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,3);
		Point p4 = new Point(4,4);
		
		a.addPoint(p1);
		a.addPoint(p2);
		a.addPoint(p3);
		a.addPoint(p4);
		
		a.removePoint(0);
		
		System.out.println(a.getPoint(0).getXY());
		
		
		
		
	}
	
}