import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mihail on 13.04.2017.
 */

public class MyCSV {
    private static final String DEFAULT_SEPARATOR = ",";
    private String spliterator;
    private File file;

    public MyCSV(File file) {
        spliterator = DEFAULT_SEPARATOR;
        this.file = file;
    }

    public MyCSV(File file, String spliterator) {
        this.spliterator = spliterator;
        this.file = file;
    }

    public String[][] readCSVFile() throws MyCSVException {

        ArrayList<String[]> arrayList = new ArrayList<>();
        String str;

        try (Scanner sc = new Scanner(file, "UTF-8")) {
            while (sc.hasNext()) {
                str = sc.nextLine();
                arrayList.add(str.split(spliterator));
            }
        } catch (IOException ex) {
            throw new MyCSVException("Ошибка работы с файлом");
        }
        String[][] arr = new String[arrayList.size()][arrayList.get(0).length];
        return arrayList.toArray(arr);
    }

    public void writeCSVInFile(String[][] array) throws MyCSVException, IOException {
        try( BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            String str = "";
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    str += (array[i][j]);
                    if(j < array[0].length - 1) {
                        str += spliterator;
                    }
                }
                if(i < array.length - 1) {
                    str += ("\n");
                }
            }
            bufferedWriter.write(str);
        } catch (IOException ex) {
            throw new MyCSVException("Ошибка в работы с файлом", ex);
        }
    }
}
