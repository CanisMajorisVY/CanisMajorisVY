
public class T2 {
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		double x = Double.parseDouble(args[1]);
		double c = 0;
		
		for ( int i = 0; i < n; i++ ) {
			c = Math.cos(x + c);
		}
		
		System.out.println(c);
	}
}


