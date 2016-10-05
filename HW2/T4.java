// Вход: первые два членна ар. прогрессии Выход: n-ный член ар. прогрессии
public class T4 {
	public static void main(String[] args) {
	int a1 = Integer.parseInt(args[0]);
	int a2 = Integer.parseInt(args[1]);
	int n = Integer.parseInt(args[2]);
	int ch, q;
	
	q = a2- a1;	
	ch = a1 + q * (n - 1);
	
	System.out.print(ch);
	}
}


