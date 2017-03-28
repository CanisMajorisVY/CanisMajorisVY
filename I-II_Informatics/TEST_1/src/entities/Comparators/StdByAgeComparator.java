package entities.Comparators;

import java.util.Comparator;
import entities.Student;
/**
 * Created by Mihail on 21.03.2017.
 */
public class StdByAgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student std1, Object std2) {
        if(std1 instanceof entities.Student && std2 instanceof entities.Student) {
            std1 = (entities.Student) std1;
            std2 = (entities.Student) std2;
            if (std1.getAge() > std2.getAge()) {
                return 1;
            } else if (std1.getAge() < std2.getAge()) {
                return -1;
            }
            return 0;
        }
    }
}
