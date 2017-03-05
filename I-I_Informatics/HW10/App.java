import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(integral(a,b,n));
        System.out.println(trapIntegral(a,b,n));
        System.out.println(parabIntegral(a,b,n));
    }

    public static double f(double x) {
        return x * Math.sin(x);
    }

    public static double integral(double a, double b, int n){
        double d, s = 0;
        d = (b - a) / n;
        for (double i = a; i < b; i += d) {
            s += f(i);
        }
        s *= d;
        return s;
    }

    public static double trapIntegral(double a, double b, int n) {
        double d, s = 0;
        d = (b - a) / n;
        for (double i = a; i < b; i += d) {
            s += (f(i) + f(i + d)) / 2;
        }
        s *= d;
        return s;
    }

    public static double parabIntegral(double a, double b, int n) {
        double h, s1 = 0, s2 = 0;
        h = (b - a) / (2 * n);
        for(double i = a + h; i + h < b; i += 2 * h) {
            s1 += f(i);
        }
        for(double i = a + 2 * h; i < b - 2 * h; i += 2 * h) {
            s2 += f(i);
        }
        s1 = (4 * s1 + 2 * s2 + f(a) + f(b)) * h / 3;
        return s1;
    }

}
