//Вывод тркугольника
public class T12 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		for (int i = 0; i <= n/2; i++) {
			for (int j = -n/2; j < n/2+1; j++) {
				if (Math.abs(j) <= i) {
					System.out.print("*");
				} 	else 
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
