import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihail on 29.05.2017.
 */
public class App {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Bce\\univ\\GitHub\\ITIS-Homework\\I-II_Informatics\\#16_ParsingFromMagnetSeller\\src\\Конструкторы Neocube _ Неокубы и Тетракубы.html");
        Scanner sc = new Scanner(file);
        String str = "", str1 = "";
        while (sc.hasNext()) {
            str += sc.nextLine() + "\n";
        }
        Pattern pattern = Pattern.compile("<div class=\"product-name\".*>(.*)</a>");
        Matcher matcher = pattern.matcher(str);
        Pattern pattern1 = Pattern.compile("<tr class=\"even\"><th>Производитель</th><td><a.*>(.*)</a>");
        Matcher matcher1 = pattern1.matcher(str);
        Pattern pattern2 = Pattern.compile("<div class=\"price-current\">[ \\t\\n]*<strong>([0-9]*)[^0-9]*([0-9]*)<\\/strong>");
        Matcher matcher2 = pattern2.matcher(str);

        while (matcher.find()) {
            str1 += "Название: ";
            str1 += matcher.group(1) + "\nПроизводитель: ";
            matcher1.find();
            str1 += matcher1.group(1) + "\nЦена: ";
            matcher2.find();
            str1 += matcher2.group(1) + matcher2.group(2) + "\n\n";

        }

        System.out.println(str1);
    }
}
