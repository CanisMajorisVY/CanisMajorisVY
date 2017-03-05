import java.util.Arrays;

public class App {
	public static void main (String[] args) {
	char[] charAr = new char[4];
	
	
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	MyString str1 = new MyString("mama");
	MyString str2 = new MyString("papa");
	MyString str3 = new MyString("mama");
	//----------------------------------------------
	str1.concat(str2);
	System.out.println(str1.toString());
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	charAr = str2.toCharArray();
	System.out.println(Arrays.toString(charAr));
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	System.out.println(str1.charAt(0));
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	str3.concat(str1);
	System.out.println(str1.indexOf(str2)+ " " +str1.indexOf(str3));
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	str1 = str1.substr(0,6);
	System.out.println(str1.toString());
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	System.out.println(str1.equals(str1) + " " + str1.equals(str2));
	System.out.println("---------------------------------------------");
	//----------------------------------------------
	System.out.println((str1.split('m')).toString());
	
	
	}
}