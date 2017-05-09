import java.util.Arrays;
import java.util.Random;

/**
 * Created by Mihail on 20.04.2017.
 */
public class App {
    public static void main(String[] args) {
        int n = 512;

        int[][] ar1 = new int[n][n];
        int[][] ar2 = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar1[i][j] = new Random().nextInt(100) + 1;
                ar2[i][j] = new Random().nextInt(100) + 1;
            }
        }


//        printMatr(ar1);
//        printMatr(ar2);
//        printMatr(MatrixMulter.standartMult(ar1,ar2));
//        printMatr(MatrixMulter.strassenMult(ar1,ar2));

        long t = System.nanoTime();
            MatrixMulter.strassenMult(ar1,ar2);
        t = System.nanoTime() - t;

        System.out.println(t / 1000000);

        t = System.nanoTime();
        MatrixMulter.standartMult(ar1,ar2);
        t = System.nanoTime() - t;

        System.out.println(t / 1000000);


    }

    public static void printMatr(int[][] ar) {
        for(int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.print(ar[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
