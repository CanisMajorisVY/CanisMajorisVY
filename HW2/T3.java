//Подсчет формулы (от m = 1 до n) СУММА ((m-1)!)^2/((2m)!) 
public class T3 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double s = 0.5, f1 = 1, f2 = 2;
		int k1 = 1;
		for (int i = 2; i <= n; i++) {
			f1 *= (i - 1);
			f2 *= (i+k1)*(i+k1+1);
			k1++;
			s += f1 * f1 / f2;
		}
		System.out.println(s);
		
	}
}
