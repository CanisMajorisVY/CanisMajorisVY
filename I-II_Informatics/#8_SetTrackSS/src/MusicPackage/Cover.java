package MusicPackage;

import java.util.Comparator;

/**
 * Created by Mihail on 12.03.2017.
 */
public class Cover implements Comparable<Cover> {

    private String image;

    public Cover(){

    }

    public Cover(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public void setCover(String image){
        this.image = image;
    }

    @Override
    public int compareTo(Cover o) {
        return image.compareTo(o.getImage());
    }
}
