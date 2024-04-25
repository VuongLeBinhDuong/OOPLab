package AimsProject.hust.soict.ict.test.media;

import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByTitleCost;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByCostTitle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {
    public static void main(String[] args) {
        Book media1 = new Book(1, "The Lion King", "Horror", 19.95f);
        Book media2 = new Book(2, "The Lion King 2", "Sci-fi", 18.99f);
        Book media3 = new Book(3, "The Lion King 3", "Romance", 19.0f);
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
