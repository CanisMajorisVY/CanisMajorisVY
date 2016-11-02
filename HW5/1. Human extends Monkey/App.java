public class App {
	public static void main (String[] args) {
		
		Bonobo monkey1 = new Bonobo(50, true, "white");
		Bonobo monkey2 = new Bonobo(50, true, "white");
		Bonobo monkey3 = new Bonobo(40, false, "white");
		Human masha = new Human(43, true, "white", 100, 100);
		Human tanya = new Human(42, true, "white", 110, 80);
		Human oleg = new Human(43, true, "white", 100, 100);
		
		System.out.println(masha.hashCode());
		System.out.println(tanya.hashCode() + "\n");
		
		System.out.println(masha.equals(tanya) + "\n\n");
		
		tanya = masha.clone();
		
		System.out.println(masha.hashCode());
		System.out.println(tanya.hashCode() + "\n");

		System.out.println(masha.equals(tanya) + "\n\n");
		
		System.out.println(monkey1.hashCode());
		System.out.println(monkey3.hashCode() + "\n");
		
		monkey1 = monkey3.clone();
		
		System.out.println(monkey1.hashCode());
		System.out.println(monkey3.hashCode() + "\n");

		System.out.println(monkey1.equals(monkey3));
		
	}
}