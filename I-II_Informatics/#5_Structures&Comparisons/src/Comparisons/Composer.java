package Comparisons;

/**
 * Created by Mihail on 28.02.2017.
 */
public class Composer implements Comparable<Composer> {

    public static int numberOfListens;
    private String name;

    public Composer(String name, int numberOfListens){
        this.name = name;
        this.numberOfListens = numberOfListens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfListens() {
        return numberOfListens;
    }

    public void setNumberOfListens(int numberOfListens) {
        Composer.numberOfListens = numberOfListens;
    }

    @Override
    public int compareTo(Composer composer){
        return name.compareTo(composer.getName());
    }

}
