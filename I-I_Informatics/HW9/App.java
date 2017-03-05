import java.util.Scanner;
public class App {
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fun (n, 0, 1, 1, 10));
		
	}
	
	public static int fun (int n, int sum, int now, int num, int q) {
		
		now = now * q;
		sum += now;
		
		num++;
		
		if (num % 2 == 0) {
			q = q - 2;
		} 
		else {
			q++;
		}
		
		if (q < 2) {
			q = 2;
		}
		
		if (num <= n) {
			return fun(n, sum, now, num, q);
		}
		
		return sum;
		
	}
}