//Вывод круга
public class T13 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]) - 1;	
		for (int i = -n; i <= n; i++) {
			for (int j = -n; j <= n; j++) {
				if (i * i + j * j <= n * n + n / 3) 
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}