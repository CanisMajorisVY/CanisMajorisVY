//Поменять две переменные местами, не используя третью
public class T1 {
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		x = x + y;
		y = x - y;
		x = x - y;
		
		System.out.print(x + "  " + y);
		
	}
}
