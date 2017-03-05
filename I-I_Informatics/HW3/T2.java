public class T2 {
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int m = n + 1;
		int a[][] = new int[n][m];
		a[0][n -  1] = 1;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				a[i][j] = a[i - 1][j] + a[i - 1][j + 1];
			}
		}
		
		int q = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m -1; j++) {
				q  = n / 3 + 1;
				if (a[i][j] != 0) {
					System.out.printf("%" + q + "d",a[i][j]);
				} 
				else {
					for(int w = 0; w < q / 2; w++) {
						System.out.printf(" ");	
					}
				}					
			}
			System.out.println("");
		}
		
	}
}
