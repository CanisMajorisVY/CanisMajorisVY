import fileManager.FileManager;

import java.io.File;

/**
 * Created by Mihail on 14.04.2017.
 */
public class TestApp {
    public static void main(String[] args) {
        File file = new File("C://Bce//univ//GitHub//ITIS-Homework//I-II_Informatics//#9_FileSystem//src//filePackage//subFilePackage//testFile");

        FileManager fileManager = new FileManager();






        System.out.print(file.canRead());
    }
}
