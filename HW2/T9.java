// Вывод делителей
public class T9 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				
				System.out.print(i + " " + n / i + " ");
			}
		}
	
	}
}


