//Перевод из десятичной с.с. в k - с.с. (k <= 10);
public class T6 {
	public static void main(String[] args) {
		int c = Integer.parseInt(args[0]);
		int a = Integer.parseInt(args[1]);
		int s = 0;
		int[] ar = new int[20];
		int i;
		
		for (i = 0; c > 0; i++) {
			ar[i] = c % a;
			c = c / a;
		}

		for (i-= 1; i > -1; i--) {
			System.out.print(ar[i]);
			s += ar[i] ;
		}
		
		System.out.println();
		
		
		for (i = 0; s > 0; i++) {
			ar[i] = s % a;
			s = s / a;
		}
		
		for (i-= 1; i > -1; i--) {
			System.out.print(ar[i]);
		}
	}
}


