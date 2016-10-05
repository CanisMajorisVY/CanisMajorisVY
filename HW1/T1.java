
public class T1 {
	public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	double s = 1, j = -1;
	for (int i = 1;  i < n+1; i++) {
		s += j * 1.0 / (((i + 1)* 2 - 1) * ((i + 1)* 2 - 1)) ;
		j *= -1;
	}
	System.out.println(s);
	}
} 
 

