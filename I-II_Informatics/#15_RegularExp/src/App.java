import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihail on 04.05.2017.
 */
public class App {
    public static void main(String[] args) {
        String str = "vk@kkk.net";
        System.out.print(task3(str));
    }


    public static String task1(String str) {
        Pattern pattern = Pattern.compile("(?:([a-z0-9-]+)\\.)+([a-z0-9-])+");
        Matcher matcher = pattern.matcher(str);
        String s = "";
        while(matcher.find()) {
            s += matcher.group() + "\n";
        }
        return s;
    }

    public static boolean task2(String str){
        return str.matches("^(([a-z0-9-]+)\\.)+[a-z0-9-]+$");
    }

    public static boolean task3(String str) {
        Pattern pattern = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@[a-z0-9](([-a-z0-9]{0,61}[a-z0-9])?\\.)*[a-z0-9-]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
