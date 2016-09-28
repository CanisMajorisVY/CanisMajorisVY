//Перевод числа в двоичную систему счисления, подсчет кол-ва единиц.
public class T5 {
	public static void main(String[] args) {
		int c = Integer.parseInt(args[0]);
		int[] ar = new int[20];
		int i, j = 0;
		
		for (i = 0; c > 0; i++) {
			ar[i] = c % 2;
			if (ar[i] % 2 == 1) {
				j++;
			}
			c = c / 2;
		}

		for (i-= 1; i > -1; i--) {
			System.out.print(ar[i]);
		}
		
		System.out.println();
		System.out.println(j);
	}
}


