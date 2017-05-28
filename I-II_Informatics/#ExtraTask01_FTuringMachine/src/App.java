import java.util.Arrays;

/**
 * Created by Mihail on 20.05.2017.
 */
public class App {
    public static void main(String[] args) {
        String[][] str = {{"S1,0,S1,0,R", "S2,0,S3,\0,S",},
                          {"S1,1,S1,1,R", "S2,1,S3,\0,S",},
                          {"S1,\0,S2,\0,L", "S2,\0,S3,1,S"}};
        MyTuringMachine myTuringMachine = new MyTuringMachine(str, "S1", "S3");
        System.out.print(myTuringMachine.tapeOn("1"));
    }
}
