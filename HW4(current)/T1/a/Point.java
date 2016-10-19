import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Point {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		File f = new File("C:\\T.txt");
		
		PointViewer pv = new PointViewer();
		DistanceCalculator dc = new DistanceCalculator();
		Scanner sc = new Scanner(f);
		
		double x0 = sc.nextDouble();
		double y0 = sc.nextDouble();
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double d;
		
		d = dc.calcDistance(x0, y0, x, y);
		
		pv.showDistance(d);
		
	}
}