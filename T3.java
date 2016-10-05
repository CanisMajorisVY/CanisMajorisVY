public class T3 {
	public static void main(String[] args) {
		boolean q, q1 = true;
		//Ввод кол-ва элементов 1 массива, а затем самих элементов.
		int n = Integer.parseInt(args[0]);
		int[] a1 = new int[n];
		
		for ( int i = 0; i < n; i ++) {
			a1[i] = Integer.parseInt(args[i + 1]);
		}
		
		//Ввод кол-ва элементов 2 массива, а затем самих элементов.
		int m = Integer.parseInt(args[n + 1]);
		int[] a2 = new int[m];
		
		for ( int i = 0; i < m; i ++) {
			a2[i] = Integer.parseInt(args[n + i + 2]);
		}
		//------------------------------------------------
		
		if (m > n) {
			System.out.println("Второй массив не является подмассивом первого");
		} 
		else {
			for (int i = 0; i <= n - m; i++) {
				q = true;
				for (int j = 0; j < m; j++ ) {
					if (a2[j] != a1[i + j]) {
						q = false;
						break;
					}
				}
				if (q) {
						System.out.println(i);
						q1 = false;
						break;
					}
			}
		}
		if (q1) {
			System.out.println("Второй массив не является подмассивом первого");
		}
	}
}
