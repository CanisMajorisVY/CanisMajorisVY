/**
 * Created by Mihail on 27.04.2017.
 */
public class App {
    public static void main(String[] args) throws Exception{
        fun2();
    }

    public static void fun2() throws Exception {
        long i = 33;
        long j = 33;

        BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
        BoolNumbersArray boolNumbersArray2 = new BoolNumbersArray(j);

        BoolNumbersArray boolNumbersArray3 = boolNumbersArray1.caracubaMult(boolNumbersArray1, boolNumbersArray2);

        System.out.print(boolNumbersArray3.to10String());

    }

    public static void fun1() throws Exception {
        BoolNumbersArray boolNumbersArray;
        BoolNumbersArray boolNumbersArray1;
        String str = "";
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                boolNumbersArray = new BoolNumbersArray(i);
                boolNumbersArray1 = new BoolNumbersArray(j);

                str += (i + "\t\t" + j +"\t\t" +  boolNumbersArray.toString() + " \t\t\t" + boolNumbersArray1.toString());



                str += (" \t\t\t" + boolNumbersArray.toString() + " \t\t\t" + boolNumbersArray.to10String() + " \t\t\t");
                if(i*j != boolNumbersArray.to10Int()) System.out.println(str);
                str = "";
            }
        }
    }



}

