import java.util.Iterator;

/**
 * Created by Mihail on 06.03.2017.
 */
public class App {
    public static void main(String[] args) {
        Collection<String> col1 = new Collection<>();
        col1.add("1");
        col1.add("2");
        col1.add("3");
        col1.add("4");
        col1.add("5");
        Collection<String> col2 = new Collection<>();
        col2.add("3");
        col2.add("4");

        col1.addAll(col1);


        Iterator<String> iterator = col1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


    }
}
