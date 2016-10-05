public class T5 {
	public static void main(String[] args) {
		
		boolean q, q1 = true;
		String s1 = args[0];
		String s2 = args[1];
		
		if (s2.length() > s1.length()) {
			System.out.println("Вторая строка не входит в первую");
		} 
		else {
			for (int i = 0; i <= s1.length() - s2.length(); i++) {
				q = true;
				for (int j = 0; j < s2.length(); j++ ) {
					if (s2.charAt(j) != s1.charAt(i + j)) {
						q = false;
						break;
					}
				}
				if (q) {
						System.out.println(i);
						q1 = false;
						break;
					}
			}
		}
		if (q1) {
			System.out.println("Вторая строка не входит в первую");
		}
		
		
		
	}
}
