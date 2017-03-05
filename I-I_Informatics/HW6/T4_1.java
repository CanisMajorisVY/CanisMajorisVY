import java.util.Scanner;
public class T4_1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		s = s.replaceAll("[^(){}\\]\\[]", "");
		
		s = checkIfStrIsRight(s);
		
		if (s.length() == 0) {
			System.out.println("Is rigth");
		} 
		else {
			System.out.println("Isn't rigth");
		}
		
	}
	
	public static String checkIfStrIsRight(String str) {
		String s1 = str;
		str = str.replace("()", "");
		str = str.replace("{}", "");
		str = str.replace("[]", "");
		
		if (!str.equals(s1)) {
			return checkIfStrIsRight(str);
		} 
			return str;
		
	}
}

