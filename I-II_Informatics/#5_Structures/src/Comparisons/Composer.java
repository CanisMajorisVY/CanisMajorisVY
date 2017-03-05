package Comparisons;

/**
 * Created by Mihail on 28.02.2017.
 */
public class Composer {

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

    public static int getNumberOfListens() {
        return numberOfListens;
    }

    public static void setNumberOfListens(int numberOfListens) {
        Composer.numberOfListens = numberOfListens;
    }


}
