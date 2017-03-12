package OneDirectionLinkedList;

import java.util.Iterator;

/**
 * Created by Mihail on 09.03.2017.
 */
public class App {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");
        list.add("s4");
        list.addAfter("s2", "s2");
        list.addAfter("s2", "s4");
        list.remove("s3");

        LinkedList<String> list1 = new LinkedList<>();

        list1.add("s5");
        list1.add("s6");
        list1.add("s7");
        list1.add("s8");

        list.merge(list1);


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }

        System.out.print("\n" + list.get("s4") + "  " + list.has("s8"));

    }
}
