package AimsProject.hust.soict.ict.test.media;

import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByTitleCost;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByCostTitle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {
    public static void main(String[] args) {
        Media media1 = new Media(1, "The Lion King", "Horror", 19.95f);
        Media media2 = new Media(2, "The Lion King 2", "Sci-fi", 18.99f);
        Media media3 = new Media(3, "The Lion King 3", "Romance", 19.0f);
        List<Media> media = new ArrayList<Media>();
        media.add(media1);
        media.add(media2);
        media.add(media3);
        Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
        Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
        for (Media m : media) {
            System.out.println(m.toString());
        }
        media.sort(COMPARE_BY_COST_TITLE);
        for (Media m : media) {
            System.out.println(m.toString());
        }
    }
}
