import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Mihail on 15.04.2017.
 */
public class App {
    public static void main(String[]  args) throws MyCSVException, IOException {
        File file = new File("C:\\Bce\\univ\\GitHub\\ITIS-Homework\\I-II_Informatics\\#12_CSVLibrary\\src\\TestCSVFile");
        MyCSV myCSV = new MyCSV(file);
        String[][] array = {{"m", "m", "m", "m", "m"}, {"m", "m", "m", "m", "m"}, {"m", "m", "m", "m", "m"}};

//        array = myCSV.readCSVFile();

//        for(int i = 0; i < array.length; i ++) {
//            System.out.println(Arrays.toString(array[i]));
//        }

        myCSV.writeCSVInFile(array);







    }
}
