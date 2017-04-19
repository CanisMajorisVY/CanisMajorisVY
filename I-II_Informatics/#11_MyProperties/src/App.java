import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by Mihail on 19.04.2017.
 */
public class App {
    public static void main (String[] args) throws IOException {
        File f = new File("C:\\Bce\\univ\\GitHub\\ITIS-Homework\\I-II_Informatics\\#11_MyProperties\\src\\Param");
        InputStream IS = new FileInputStream(f);

        MyProperties myProperties = new MyProperties();

        myProperties.load(IS);
        myProperties.setProperty("heehe", "dsd1");
        myProperties.setProperty("heeh2", "dsd2");
        OutputStream t = new FileOutputStream(f);
        myProperties.store(t);
        myProperties.list(System.out);
        t.close();
        IS.close();
    }
}
