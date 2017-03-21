package entities.Comparators;

import entities.Student;

import java.util.Comparator;

/**
 * Created by Mihail on 21.03.2017.
 */
public class ComparatorsFabric {

    public Comparator<Student> getComparator(Object obj){
        if (obj instanceof String){
            return new StdByBallComparator();
        }
        return null;
    }

    public Comparator<Student> getComparator(int o){
       return new StdByAgeComparator<>();
    }

}
