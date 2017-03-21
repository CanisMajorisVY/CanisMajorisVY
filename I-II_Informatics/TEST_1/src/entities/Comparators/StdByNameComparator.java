package entities.Comparators;

import java.util.Comparator;

/**
 * Created by Mihail on 21.03.2017.
 */
public class StdByNameComparator<Student>  implements Comparator<Student> {

    @Override
    public int compare(Object std1, Object std2) {
        if(std1 instanceof entities.Student && std2 instanceof entities.Student) {
            return (entities.Student)std1.getName().compareTo((entities.Student)std2.getName());
        }
    }
}
