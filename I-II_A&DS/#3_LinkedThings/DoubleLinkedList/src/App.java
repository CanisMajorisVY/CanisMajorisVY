import java.util.Iterator;

/**
 * Created by Mihail on 09.03.2017.
 */
public class App {
    public static void main(String[] args){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.addFirst("s1");
        list.addFirst("s2");
        list.addLast("s3");
        list.addLast("s4");
        list.addLast("s5");
        list.addAfter("s6", "s1");
        list.remove("s4");

        DoubleLinkedList<String> list1 = new DoubleLinkedList<>();

        list1.addFirst("s9");
        list1.addFirst("s8");
        list1.addLast("s7");

        list.merge(list1);

        int i = list.get("s6");


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }

        System.out.println("\n" + i + " " + list.has("s1"));

        Iterator<String> descendingIterator = list.descendingIterator();

        while (descendingIterator.hasNext()){
            System.out.print(descendingIterator.next().toString() + " ");
        }






    }
}
