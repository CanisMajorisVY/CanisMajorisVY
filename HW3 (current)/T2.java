public class T2 {
	public static void main(String[] args) {
		
		int n = 10;
		int m = 11;
		int a[][] = new int[n][m];
		a[0][9] = 1;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				a[i][j] = a[i - 1][j] + a[i - 1][j + 1];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m -1; j++) {
				if (a[i][j] != 0) {
					System.out.printf("%4d",a[i][j]);
				} 
				else {
					System.out.printf("  ");
				}					
			}
			System.out.println("");
		}
		
	}
}
