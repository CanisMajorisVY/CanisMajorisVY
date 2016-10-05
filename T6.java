public class T6 {
	public static void main(String[] args) {
		String s = args[0];
		boolean q = false;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				q = true;
				break;
			}				
		}
		
		if (q) {
			System.out.println("NO");
		} 
		else {
			System.out.println("YES");
		}
	}
}
