import java.io.*;

/**
 * Created by Mihail on 18.04.2017.
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //classSerialization();
        //primitiveTypeSerialization();

    }

    public static void classSerialization() throws IOException, ClassNotFoundException {
        File f = new File("C:\\Bce\\univ\\GitHub\\ITIS-Homework\\I-II_Informatics\\#13_Serialization\\src\\ser");
        InputStream FIS = new FileInputStream(f);
        OutputStream FOS = new FileOutputStream(f);
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        SomeClass s;
        OOS.writeObject(new SomeClass());
        OOS.close();
        ObjectInputStream OIS = new ObjectInputStream(FIS);
        s = (SomeClass)OIS.readObject();
        System.out.print(s.q);
        OIS.close();
    }

    public static void primitiveTypeSerialization() throws IOException, ClassNotFoundException {
        File f = new File("C:\\Bce\\univ\\GitHub\\ITIS-Homework\\I-II_Informatics\\#13_Serialization\\src\\ser2");
        InputStream FIS = new FileInputStream(f);
        OutputStream FOS = new FileOutputStream(f);
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        int n = 5;
        OOS.writeObject(n);
        OOS.close();
        n = 0;
        ObjectInputStream OIS = new ObjectInputStream(FIS);
        n = (int)OIS.readObject();
        System.out.print(n);
        OIS.close();
    }
}
