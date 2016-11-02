import java.util.Scanner;

public class T4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = 0;
		boolean q = false;
		String s = sc.nextLine();
		String s1 = "";
		
		for (int i = 0; i < s.length(); i ++) {
			if ((s.charAt(i) == '(')) {
				w += 1;
			}
			else if (s.charAt(i) == ')') {
				w -= 1;
			}
			
			if (w < 0) {
				q = true;
				break;
			}	
		}
		
		if (w != 0) {
			System.out.println("wrong");
		} 
		else {
			System.out.println("true");
		}
		
		
		System.out.println(s1);
		
	}
}
