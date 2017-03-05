//Факториал
public class T2 {
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int f = 1;
		
			for (int i = 0; i < n; i++) {
				f = f * (i+1);
			}
		
		System.out.println(f);
	}
}
