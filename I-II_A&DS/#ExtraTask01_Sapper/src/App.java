import java.util.Scanner;
import java.util.Random;

/**
 * Created by Mihail on 02.02.2017.
 */

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m, x, y, h;
        char z;
        String s = "    ";
        System.out.print("ВВедите уровень сложности от 1 до 5: ");
        h = sc.nextInt();
        System.out.print("Введите размеры игрового поля через пробел: ");
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.print("Введите началльную позицию: ");
        x = sc.nextInt();
        y = sc.nextInt();
        Pole field = new Pole(n, m);
        field.setHardness(h);
        field.createMap(x-1, y-1);
        field.checkplace(x-1, y-1, 'm');


        field.showMap();
        while(!field.gameIsOver()) {
            System.out.print("Введите позицию и пометьте бомбу (b), снимите пометку (n) или сделайте ход (m): ");
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.next().charAt(0);
            field.checkplace(x-1, y-1, z);
            field.showMap();
        }
        if (field.gameIsOver() && !field.weWin()) {
            System.out.print("game over");
        } else if(field.gameIsOver()){
            System.out.print("victory");
        }
    }
}
