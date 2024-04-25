package AimsProject.hust.soict.ict.test.store;

import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star War", "Science Fiction", 24.95f, 87, "Geoger Lucas");
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Star War", "Animation", 18.99f);
        store.addMedia(dvd3);
        Book dvd4 = new Book(4, "Aladin 2", "Animation2", 10.24f);
        store.addMedia(dvd4);
        store.print();
        Media item = store.searchTitle("The Lion King");
        System.out.println(item.getTitle());
    }
}
