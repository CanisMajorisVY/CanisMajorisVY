import java.util.Arrays;

/**
 * Created by Mihail on 27.04.2017.
 */
public class App {
    public static void main(String[] args) throws Exception{
        fun5(20);



    }
    public static void fun8(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        BoolNumbersArray boolNumbersArray2;
        boolNumbersArray1 = new BoolNumbersArray(15);
        boolNumbersArray2 = new BoolNumbersArray(10);
        System.out.print(boolNumbersArray1.lPart().mult2powN(boolNumbersArray1.realLength()));
    }

    public static void fun6(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= 10; j++) {
                boolNumbersArray1 = new BoolNumbersArray(i);
                System.out.print(boolNumbersArray1.to10Int() + " ");
                boolNumbersArray1.div(new BoolNumbersArray(j));
                System.out.print(boolNumbersArray1.to10Int() + " | ");
            }
            System.out.println();
        }
    }

    public static void fun5(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        BoolNumbersArray boolNumbersArray2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolNumbersArray1 = new BoolNumbersArray(i);
                boolNumbersArray2 = new BoolNumbersArray(j);
                if(i * j != BoolNumbersArray.mult(boolNumbersArray1, boolNumbersArray2).to10Int()) {
                    System.out.print(boolNumbersArray1 + "   " + boolNumbersArray2 + "   " + BoolNumbersArray.mult(boolNumbersArray1, boolNumbersArray2).toString() + "   ");
                    System.out.println(boolNumbersArray1.to10Int() + "   " + boolNumbersArray2.to10Int() + "   " + BoolNumbersArray.mult(boolNumbersArray1, boolNumbersArray2).to10Int() + "  " + (i * j));
                }
            }
        }
    }

    public static void fun4(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        for(int i = 0; i < n; i++) {
            boolNumbersArray1 = new BoolNumbersArray(i);
            for(int j = 0; j < 5; j++) {
                System.out.print(boolNumbersArray1 + " ");
                boolNumbersArray1.div2();
                System.out.print(boolNumbersArray1 + " | ");
            }
            System.out.println();
        }
    }

    public static void fun3(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        BoolNumbersArray boolNumbersArray2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i >= j) {
                    boolNumbersArray1 = new BoolNumbersArray(i);
                    boolNumbersArray2 = new BoolNumbersArray(j);
                    if (i - j != BoolNumbersArray.substract(boolNumbersArray1, boolNumbersArray2).to10Int()) {
                        System.out.print(boolNumbersArray1 + "   " + boolNumbersArray2 + "   " + BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2).toString() + "   ");
                        System.out.println(boolNumbersArray1.to10Int() + "   " + boolNumbersArray2.to10Int() + "   " + BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2).to10Int() + "  " + (i - j));
                    }

                }
            }
        }
    }

    public static void fun2(int n) throws Exception {
        BoolNumbersArray boolNumbersArray1;
        BoolNumbersArray boolNumbersArray2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolNumbersArray1 = new BoolNumbersArray(i);
                boolNumbersArray2 = new BoolNumbersArray(j);
                if(i + j != BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2).to10Int()) {
                    System.out.print(boolNumbersArray1 + "   " + boolNumbersArray2 + "   " + BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2).toString() + "   ");
                    System.out.println(boolNumbersArray1.to10Int() + "   " + boolNumbersArray2.to10Int() + "   " + BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2).to10Int() + "  " + (i + j));
                }
            }
        }
    }

    public static void fun1(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(new BoolNumbersArray(i).toString());
        }
    }
}

