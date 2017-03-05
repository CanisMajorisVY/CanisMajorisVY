import java.util.Arrays;

public class MyString {
	private char[] arString;
	
	public MyString() {
		arString = new char[0];
	}
	
	public MyString(String str) {
		arString = str.toCharArray();
	}
	
	public void concat(MyString aStr) {
		char[] newAr = new char[arString.length + aStr.length() + 1];
		System.arraycopy(arString, 0, newAr, 0, arString.length);
		System.arraycopy(aStr.arString, 0, newAr, arString.length, aStr.length());
		arString = newAr;
	}
	
	public char[] toCharArray() {
        return arString;
    }
	
	public char charAt(int i) {
		return arString[i];
	}
	
	public int indexOf(MyString str) {
		boolean q, q1 = true;
		if (arString.length > str.length()) { 
			for (int i = 0; i <= arString.length - str.length(); i++) {
				q = true;
				for (int j = 0; j < str.length(); j++ ) {
					if (str.charAt(j) != arString[i + j]) {
						q = false;
						break;
					}
				}
				if (q) {
						return (i);
				}
			}
		}	
			return -1;
	}
	
	public MyString substr(int start, int length) {
		char[] newAr = new char[length];
		System.arraycopy(arString, start, newAr, 0, length);
		MyString newStr = new MyString();
		newStr.arString = newAr;
		return newStr;
	}
	
	public String toString() {
        return new String(arString);
    }
	
	public boolean equals(Object str) {
		if (str == null) return false;
		MyString s = (MyString)str;
		
		return Arrays.equals(arString, s.arString);
		
	}
	
	public int length() {
        return arString.length;
    }
	
	public MyString split(char c) {
		MyString str = new MyString(new String (arString));
		for (int i = 0; i < str.length(); i++) {
			if (str.arString[i] == c) {
				char[] newAr = new char[str.length() - 1];
				System.arraycopy(str.arString, 0, newAr, 0, i);
				System.arraycopy(str.arString, i + 1, newAr, i, str.length() - i - 1);
				str.arString = newAr;
			}
		}
		return str;
	}
	
}