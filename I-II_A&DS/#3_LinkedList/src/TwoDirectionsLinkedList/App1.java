package TwoDirectionsLinkedList;

import java.util.Iterator;

/**
 * Created by Mihail on 09.03.2017.
 */
public class App1 {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
//        list.addFirst("s1");
//        list.addFirst("s2");
        list.addFirst("s3");
        list.addLast("s4");
        list.addLast("s5");


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }

        System.out.print("\n" + list.get("s4") + "  " + list.has("s8"));

    }
}
