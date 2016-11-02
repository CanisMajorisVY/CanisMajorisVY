import java.util.Arrays;
import java.util.Random;
public class T3 {
	public static void main(String[] args) {
		Random r = new Random();
		long[] a = new long[r.nextInt(6)+1];
		a[0] = r.nextInt(5) + 1;
		
		
		for (int i = 1; i < a.length; i++) {
			a[i] = a[i - 1] * a[i - 1];
		}
		
		
		System.out.println(Arrays.toString(a));
	}
}
