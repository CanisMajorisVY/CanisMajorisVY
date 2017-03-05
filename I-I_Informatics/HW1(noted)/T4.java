
public class T4 {
	public static void main(String[] args) {
		
		double x = Double.parse.Double(args[0]);
		double y = Double.parse.Double(args[1]);
		double x0 = Double.parse.Double(args[2]);
		double y0 = Double.parse.Double(args[3]);
		double r = Double.parse.Double(args[4]);
		double dx;
		double dy;
		double r1;
		
		dx = Math.abs(x - x0);
		dy = Math.abs(y - y0);
		
		r1 = dx * dx + dy * dy;
		r = r * r;
		
		if (r1 > r) {
			System.out.println("OUTSIDE");
		} else if (r1 < r) {
			System.out.println("INSIDE");
		} else {
			System.out.println("ON THE BORDER");		
		}
	}
}


