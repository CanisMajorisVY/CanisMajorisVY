package entities.Comparators;

/**
 * Created by Mihail on 21.03.2017.
 */
public class StdByBallComparator {
    @Override
    public int compare(Object std1, Object std2) {
        if(std1 instanceof entities.Student && std2 instanceof entities.Student) {
            std1 = (entities.Student) std1;
            std2 = (entities.Student) std2;
            if (std1.getSBall() > std2.getSBall()) {
                return 1;
            } else if (std1.getSBall() < std2.getSBall()) {
                return -1;
            }
            return 0;
        }
    }
}
