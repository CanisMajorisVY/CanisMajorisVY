public class T11 {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int i;
		long z, z1;
		
		z1 = System.nanoTime();
		if (x > y) {
			x = x + y;
			y = x - y;
			x = x - y;
		}
		for (i = x; i > 0; i--) {
			if ((x % i == 0)&& (y % i == 0)) {
				break;
			}
		}
		z1 = System.nanoTime() - z1;
		
		System.out.println("Время нахождения НОД методом перебора: " + z1);
		
		
		z = System.nanoTime();
		while (x != y) {
			if (x > y) {
				x = x - y;
			}
			else {
				y = y - x;
			}
		}
		z = System.nanoTime() - z;
		
		System.out.println("Время нахождения НОД алгоритмом евклида: " + z);
		System.out.println("Отношение времени м. перебора кo времени м. Евклида: " +  1.0 * z1 / z);
	}
}
