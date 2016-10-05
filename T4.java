public class T4 {
	public static void main(String[] args) {
		
		String s1 = args[0];
		String s2 = args[1];
		boolean q = false;
		
		if (s1.length() == s2.length()) {
			q = true;
			for (int i = 0; i < s1.length(); i++ ) {
				if (s1.charAt(i) != s2.charAt(i)) {
					q = false;
					break;
				}
			}
		}
		
		if (q) {
			System.out.println("equal");
		} 
		else {
			System.out.println("not equal");
		}
			
		
	}
}
