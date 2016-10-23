public class App {
	public static void main (String[] args) {
		
		BigOrbitalStation c1 = new BigOrbitalStation(100, 2, true, 100, true, true);
		BigOrbitalStation c2 = new BigOrbitalStation(100, 2, true, 100, true, true);;
		BigOrbitalStation c3 = new BigOrbitalStation(50, 1, true, 100, false, true);;
		
		
		System.out.println(c1.StartFtlEngine());
		
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