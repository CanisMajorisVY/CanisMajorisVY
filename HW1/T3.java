/*
mgh = mv^2/2
h = v^2/2g = (at)^2/2g = gt^2/2
---
*/

public class T3 {
	public static void main(String[] args) {
		
		double t  = Double.parseDouble(args[0]); // в секундах
		double g = 9.81, h;
		
		h = g * t * t / 2;
		
		System.out.printf("%.2f", h);
		
		
	}
}


