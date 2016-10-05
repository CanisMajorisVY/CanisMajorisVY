public class T5 {
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		double r = 1;
		double pi;
		double alfa = 360;
		int n = 1;
		
		alfa = Math.toRadians(alfa);
		
		for (int i = 0; i < x; i++){
			
			pi = n * Math.sqrt( 2 - 2 * Math.cos(alfa)) / 2;
			System.out.println(pi);
			alfa = alfa / 2.0;
			n = n * 2;
		}


		System.out.println();
		
	}
}

















/*
public class HPrak_007_05 {
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		double r = 1;
		double pi;
		double alfa = 360 / x;
		alfa = Math.toRadians(alfa);
		
		pi = x * r * Math.sqrt( 2 - 2 * Math.cos(alfa)) / (2 * r);
		
	
		
		
		System.out.println(pi);
	}
}
*/

