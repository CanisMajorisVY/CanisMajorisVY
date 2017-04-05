import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Mihail on 16.03.2017.
 */
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = r.nextInt(100000000);
//            array[i] = i;
        }

//        System.out.println(Arrays.toString((array)));

        long x;
        int[] ar = array.clone();

//        x = System.nanoTime();
//        selectionSort(ar);
//        x = System.nanoTime() - x;
//        System.out.println("selectionSort " + x / 1000000);
//
//        ar = array.clone();
//        x = System.nanoTime();
//        insertionSort(ar);
//        x = System.nanoTime() - x;
//        System.out.println("insertionSort " + x / 1000000);

        ar = array.clone();
        x = System.nanoTime();
        mergeSort(ar);
        x = System.nanoTime() - x;
        System.out.println("mergeSort " + x / 1000000);

        ar = array.clone();
        x = System.nanoTime();
        mergInsertsort(ar);
        x = System.nanoTime() - x;
        System.out.println("mergInsertSort " + x / 1000000);


        ar = array.clone();
        x = System.nanoTime();
        Arrays.sort(array);
        x = System.nanoTime() - x;
        System.out.println("Arrays.sort " + x / 1000000);

        ar = array.clone();
        x = System.nanoTime();
        Arrays.parallelSort(array);
        x = System.nanoTime() - x;
        System.out.println("Arrays.parallelSort " + x / 1000000);

//        System.out.println(Arrays.toString(ar));





    }




    public static int[] mergeSort(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int[] arr1 = mergeSort(Arrays.copyOf(arr,arr.length / 2));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        int i = 0, j = 0, i1 = 0;

        while(i < arr1.length || j < arr2.length ){

            if(i < arr1.length & j < arr2.length) {
                arr[i1] = Math.min(arr1[i], arr2[j]);

                if(arr[i1] == arr1[i]) {
                    i++;
                } else {
                    j++;
                }
                i1++;

            } else {
                if(i == arr1.length) {
                    while (j < arr2.length) {
                        arr[i1] = arr2[j];
                        i1++;
                        j++;
                    }
                }
                if(j == arr2.length) {
                    while (i < arr1.length) {
                        arr[i1] = arr1[i];
                        i1++;
                        i++;
                    }
                }
            }
        }

        return arr;
    }

    public static void selectionSort(int[] arr) {
        int min = arr[0];
        int q = 0;
        int nElem;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    q = j;
                }
            }
            nElem = arr[i];
            arr[i] = arr[q];
            arr[q] = nElem;
        }
    }

    public static void insertionSort(int[] arr){
        int j;
        int arI;

        for(int i = 1; i < arr.length; i++) {

            j = Arrays.binarySearch(arr, 0, i, arr[i]);

            if(j < 0) {
                j = (j + 1) * -1;
            }

            arI = arr[i];

            for(int i1 = i; i1 > j; i1--) {
                arr[i1] = arr[i1 - 1];
            }
            arr[j] = arI;

        }
    }

    public static int[] mergInsertsort(int[] arr){
        if(arr.length < 40){
            insertionSort(arr);
            return arr;
        }

        int[] arr1 = mergeSort(Arrays.copyOf(arr,arr.length / 2));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        int i = 0, j = 0, i1 = 0;

        while(i < arr1.length || j < arr2.length ){
            if(i < arr1.length & j < arr2.length) {
                arr[i1] = Math.min(arr1[i], arr2[j]);

                if(arr[i1] == arr1[i]) {
                    i++;
                } else {
                    j++;
                }
                i1++;

            } else {
                if(i == arr1.length) {
                    while (j < arr2.length) {
                        arr[i1] = arr2[j];
                        i1++;
                        j++;
                    }
                }
                if(j == arr2.length) {
                    while (i < arr1.length) {
                        arr[i1] = arr1[i];
                        i1++;
                        i++;
                    }
                }
            }
        }

        return arr;
    }

}
