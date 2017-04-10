package Task1_Task2;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Mihail on 06.04.2017.
 */

//сгенерировать массив чисел
//показать
//записать
//считать
//показать
//потом тоже самое с символами


public class App {
    public static void main(String[] args) throws IOException {
        fun1();
        fun2();
    }

    public static void fun1() throws IOException{
        final int N = 10;
        File file = new File("C://Bce//univ//GitHub//ITIS-Homework//I-II_A&DS//Lesson_01//src//f");

        if(file.isFile()) {
            byte[] ar = new byte[N];
            new Random().nextBytes(ar);

            System.out.println("Изначальный массив: " + Arrays.toString(ar));

            try (OutputStream oS = new FileOutputStream(file)) {
                oS.write(ar);
                oS.close();
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

            try (InputStream iS = new FileInputStream(file)) {
                iS.read(ar);
                iS.close();
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

            System.out.println("Считанный массив: " + Arrays.toString(ar));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void fun2() throws IOException{
        final int N = 10;
        File file = new File("C://Bce//univ//GitHub//ITIS-Homework//I-II_A&DS//Lesson_01//src//f2");

        if(file.isFile()) {
            char[] ar = new char[N];
            for (int i = 0; i < N; i++) {
                ar[i] = (char) (new Random().nextInt(29) + 97);
            }

            System.out.println("Изначальный массив: " + Arrays.toString(ar));

            try (Writer writer = new FileWriter(file)) {
                writer.write(ar);
                writer.close();
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

            try (Reader reader = new FileReader(file)) {
                reader.read(ar);
                reader.close();
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

            System.out.println("Считанный массив: " + Arrays.toString(ar));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
