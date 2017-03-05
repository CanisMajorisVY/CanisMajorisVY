import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
public class T1 {
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] a = new Integer[r.nextInt(10)+1];
		
		
		for (int i = 0; i < a.length; i++ ) {
			a[i] = r.nextInt(100);
		}
		System.out.println("-------------------");
		
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < a.length / 2; i++ ) {
			int b = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = b;
		}
		
		System.out.println(Arrays.toString(a));
		
		Collections.reverse(Arrays.asList(a));
		
		System.out.println(Arrays.toString(a));
		
		
	
	}
}
