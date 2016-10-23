public class App {
	public static void main (String[] args) {
		SmartCalculator c1 = new SmartCalculator("a320", true, "clr-10899", true);
		SmartCalculator c2 = new SmartCalculator("a320", true, "clr-10899", true);
		SmartCalculator c3 = new SmartCalculator("a220", false, "clr-856", false);
		
		System.out.println(c1.sum(5, 10));
		System.out.println(c1.factorial(7));
		System.out.println(c1.toString());
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		
		c3 = c1.clone();
		
		System.out.println(c1.equals(c3));
		
	}
}