import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        int min = sc.nextInt(), max = min;
        array[0] = min;

        for (int i = 1; i < n; i++){
            array[i] = sc.nextInt();
            if(array[i] < min) {
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
        }

        int[] secondArray = new int[max - min + 1];

        Arrays.fill(secondArray, 0);

        for(int i = 0; i < n; i++) {
            secondArray[array[i] - min]++;
        }

        for(int i = 0; i < max - min + 1; i++) {
            for(int j = 0; j < secondArray[i]; j++) {
                System.out.print(i + min +  " ");
            }
        }

    }
}
