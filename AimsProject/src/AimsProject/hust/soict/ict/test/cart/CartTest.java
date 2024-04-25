package AimsProject.hust.soict.ict.test.cart;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.*;

import java.util.List;
import java.util.Comparator;

public class CartTest {
	public static Cart anOrder = new Cart();
	public static List<Media> itemsInOrdered = anOrder.getItemsOrdered();
	public static void main(String[] args) {

		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		anOrder.addMedia(dvd1);

		CompactDisc cd2 = new CompactDisc(2, "Star Wars", "Science Friction", 24.95f, "Director 1", "Artist 1");
		CompactDisc cd4 = new CompactDisc(4, "Star Wars 2", "Science Friction", 18.99f);
		Track track1 = new Track("Track1", 50);
		cd2.addTrack(track1);
		Track track2 = new Track("Track2", 40);
		cd2.addTrack(track2);
		Track track3 = new Track("Track3", 20);
		cd2.addTrack(track3);
		anOrder.addMedia(cd2);
		anOrder.addMedia(cd4);

		Book book3 = new Book(3, "Aladin", "Animation", 18.99f);
		Book book5 = new Book(5, "Aladin", "Animation", 15.32f, "Author 3", "Author 4");
		book3.addAuthor("Author 1");
		book5.addAuthor("Author 2");
		anOrder.addMedia(book3);
		anOrder.addMedia(book5);

		anOrder.print();

		System.out.println(" ");
		Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
		for (Media m : itemsInOrdered) {
			System.out.println(m.toString());
		}
		System.out.println(" ");
		itemsInOrdered.sort(COMPARE_BY_COST_TITLE);
		for (Media m : itemsInOrdered) {
			System.out.println(m.toString());
		}
	}
}

