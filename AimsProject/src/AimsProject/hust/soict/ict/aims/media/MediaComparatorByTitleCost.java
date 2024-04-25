package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if(m1.getTitle().equals(m2.getTitle())){
            if(m1.getCost() > m2.getCost()){
                return 1;
            }
            else return -1;
        }
        else return m1.getTitle().compareTo(m2.getTitle());
    }
}
