//Нахождение НОК
public class T10 {
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int nok;
		int x1 = x, y1 = y;
		while (x != y) {
			if (x > y) {
				x = x - y;
			}
			else {
				y = y - x;
			}
		}
		
		nok = y1 * x1 / x;
		System.out.println(nok);
		
	}
}
