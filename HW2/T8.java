//перевод числа в двоичную с.с. и вывод максимального кол-ва подряд идущих нулей.
public class T8 {
	public static void main(String[] args) {
		int c = Integer.parseInt(args[0]);
		int[] ar = new int[20];
		int i = 0;
		int k = 0, km = 0;
		boolean q;
		
		
		ar[i] = c % 2;
		c = c / 2;
		for (i = 1; c > 0; i++) {
			ar[i] = c % 2;
			c = c / 2;
		}
		
		for (int j = 0; j < i; j++) {
			if ( ar[j] != 0 ) {
				k = 0;
			} 
			else {
				k++;
			}
			if (k > km) {
				km = k;
			}
		}
		
		System.out.println();
		for (i-= 1; i > -1; i--) {
			System.out.print(ar[i]);
		}
		System.out.println();
		System.out.println(km);
	}
}


