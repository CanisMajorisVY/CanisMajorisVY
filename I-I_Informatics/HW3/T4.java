public class T4 {
	public static void main(String[] args) {
		
		String s1 = args[0];
		String s2 = args[1];
		boolean q = true;
		
		int minl = 0;
		
		if (s1.length() < s2.length()) {
			minl = s1.length();
		} 
		else {
			minl = s2.length();
		}	
		
		for (int i = 0; i < minl; i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				System.out.println("s1 > s2");
				q = false;
				break;
			}
			else if (s1.charAt(i) < s2.charAt(i)){
				System.out.println("s1 < s2");
				q = false;
				break;
			}
		}
	
		if (q) {
			System.out.println("s1 = s2");
		}
	}
}
