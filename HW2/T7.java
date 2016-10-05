//Перевод из десятичной с.с. в k - с.с. (k <= 36); Подсчет суммы цифр полученного числа в k - c.c. 
public class T7 {
	public static void main(String[] args) {
		int c = Integer.parseInt(args[0]);
		int a = Integer.parseInt(args[1]);
		int s = 0;
		int[] ar = new int[20];
		int i;
		char q;
		
		for (i = 0; c > 0; i++) {
			ar[i] = c % a;
			c = c / a;
		}

		for (i-= 1; i > -1; i--) {

			if (ar[i] < 10) {
				System.out.print(ar[i]);
			}
			else
			{
				q = 65;
				q += ar[i] - 10;
				System.out.print(q);
			}
			s+=ar[i];
			
		}
		
		System.out.println();

		for (i = 0; s > 0; i++) {
			ar[i] = s % a;
			s = s / a;
		}

		for (i-= 1; i > -1; i--) {
			if (ar[i] < 10) {
				System.out.print(ar[i]);
			}
			else
			{
				q = 65;
				q += ar[i] - 10;
				System.out.print(q);
			}
		}
	}
}

