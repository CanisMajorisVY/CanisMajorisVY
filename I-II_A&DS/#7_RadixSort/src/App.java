import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Mihail on 20.04.2017.
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = new Random().nextInt(10000 );
        }
        int[] array2 = array.clone();
        long t;

        t = System.nanoTime();
        array = radixSort(array);
        t = System.nanoTime() - t;

        System.out.print(/*Arrays.toString(array) + */ "\n" + t / 1000000 );

        t = System.nanoTime();
         Arrays.sort(array);
        t = System.nanoTime() - t;
        System.out.print("\n" + t / 1000000);
    }

    public static int element(int r, int i, int j, int[] array) {
        for(int w = 0; w < i; w++) {
        r *= 10;
        }
        int d = array[j] % (r * 10);

        d /= r;

        return d;
        }

    public static int[] radixSort(int[] array) {
        int max = array[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) max = array[i];
        }

        int k = 0;

        while(max > 0) {
            max /= 10;
            k++;
        }

        int[] newArray = new int[array.length];
        int u = 0;
        int r = 1;
        for(int i = 0; i < k; i++) {
            for(int num = 0; num <= 9; num++) {
                for (int j = 0; j < array.length; j++) {
                    if (element(r, i, j, array) == num) {
                        newArray[u] = array[j];
                        u++;
                    }
                }
            }
            r *= 10;
            u = 0;
            System.arraycopy(newArray, 0, array, 0, newArray.length);
            array = newArray.clone();
        }
        return array;
    }

}

