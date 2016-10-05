public class T1 {
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		int q;
		boolean z = false;
		
		for ( int i = 0; i < n; i ++) {
			a[i] = Integer.parseInt(args[i + 1]);
		}
		
		for ( int i = 0; i < n; i ++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j+1]) {
					q = a[j];
					a[j] = a[j + 1];
					a[j + 1] = q;
					z = true;
				}
			}
			
			if (z = false) {
				break;
			}
		}
		
		for ( int i = 0; i < n; i ++) {
			System.out.print(a[i] + " ");
		}
	}
}
