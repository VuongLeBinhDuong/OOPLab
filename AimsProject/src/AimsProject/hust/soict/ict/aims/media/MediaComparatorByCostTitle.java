package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if(m1.getCost() == m2.getCost()){
            return m1.getTitle().compareTo(m2.getTitle());
        }
        else if(m1.getCost() > m2.getCost()){
            return 1;
        }
        else return -1;
    }
}
