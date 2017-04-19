import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Mihail on 13.04.2017.
 */

public class MyCSV {

    private String spliterator;
    private File file;

    public MyCSV(File file) {
        this(file, ",");
    }

    public MyCSV(File file, String spliterator) {
        this.spliterator = spliterator;
        this.file = file;
    }

    public String[][] readSCVFile() throws IOException {

        ArrayList<String[]> arrayList = new ArrayList<>();
        String str;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                str = sc.nextLine();
                arrayList.add(str.split(spliterator));
            }
        } catch (IOException ex) {
            throw new IOException("Ошибка работы с файлом");
        }
        String[][] arr = new String[arrayList.size()][arrayList.get(0).length];
        return arrayList.toArray(arr);
    }
}
