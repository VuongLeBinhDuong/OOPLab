package AimsProject.hust.soict.ict.aims;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {

	public static Scanner input = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void viewStore(){
		int choice;
		do {
			storeMenu();
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
		} while (choice > 4 || choice < 0);
		switch (choice){
			case 1: {
				System.out.println("Enter the title: ");
				input.nextLine();
				String inputTitle = input.nextLine();
				Media searchTitle = store.searchTitle(inputTitle);
				if (searchTitle != null){
					seeAMediaDetail(searchTitle);
				}
				else{
					viewStore();
				}
				break;
			}
			case 2: {
				store.print();
				System.out.println("Enter the title: ");
				input.nextLine();
				String inputTitle = input.nextLine();
				Media searchTitle = store.searchTitle(inputTitle);
				if (searchTitle != null){
					cart.addMedia(searchTitle);
				}
				cart.print();
				viewStore();
				break;
			}
			case 3: {
				store.print();
				System.out.println("Enter the title: ");
				input.nextLine();
				String inputTitle = input.nextLine();
				Media searchTitle = store.searchTitle(inputTitle);
				if (searchTitle != null){
					playMedia(searchTitle);
				}
				viewStore();
				break;
			}
			case 4: {
				cart.print();
				seeCurrentCart();
			}
			case 0: {
				mainMenu();
				break;
			}
		}
	}

	public static void playMedia(Media searchTitle){
		boolean isDVD = false;
		boolean isCD = false;
		try {
			CompactDisc chosenMedia = (CompactDisc) searchTitle;
			chosenMedia.play();
			isCD = true;
		}
		catch (Exception e){

		}
		try {
			DigitalVideoDisc chosenMedia = (DigitalVideoDisc) searchTitle;
			chosenMedia.play();
			isDVD = true;
		}
		catch (Exception e){

		}
		if (!isCD && !isDVD){
			System.out.println("The chosen media is not a CD or DVD \n");
		}
	}

	public static void seeAMediaDetail(Media searchTitle){
		int choice;
		do {
			mediaDetailsMenu();
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
		} while (choice > 2 || choice < 0);
		switch (choice){
			case 1: {
				cart.addMedia(searchTitle);
				cart.print();
				viewStore();
				break;
			}
			case 2: {
				playMedia(searchTitle);
				viewStore();
				break;
			}
			case 0: {
				viewStore();
				break;
			}
		}
	}

	public static void seeCurrentCart(){
		int choice;
		do {
			cartMenu();
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
		} while (choice > 5 || choice < 0);
		switch (choice){
			case 1: {
				System.out.println("Enter choice: ");
				input.nextLine();
				String choice2 = input.nextLine();
				if (choice2.equals("ID")){
					System.out.println("Enter the ID: ");
					int inputId = input.nextInt();
					Media searchId = cart.searchId(inputId);
					if (searchId != null){
						System.out.println(searchId.toString());
					}
					else{
						System.out.println("The is no item matching input");
					}
				}
				else if (choice2.equals("Title")){
					System.out.println("Enter the title: ");
					String inputTitle = input.nextLine();
					Media searchTitle = cart.searchTitle(inputTitle);
					if (searchTitle != null){
						System.out.println(searchTitle.toString());
					}
				}
				else {
					System.out.println("Invalid input");
				}
				seeCurrentCart();
				break;
			}
			case 2: {
				System.out.println("Enter choice: ");
				input.nextLine();
				String choice3 = input.nextLine();
				if (choice3.equals("Title")){
					itemsInCart.sort(Media.COMPARE_BY_TITLE_COST);
					cart.print();
				}
				else if (choice3.equals("Cost")){
					itemsInCart.sort(Media.COMPARE_BY_COST_TITLE);
					cart.print();
				}
				else {
					System.out.println("Invalid input");
				}
				seeCurrentCart();
				break;
			}
			case 3: {
				System.out.println("Enter the title: ");
				input.nextLine();
				String inputTitle = input.nextLine();
				Media searchTitle = cart.searchTitle(inputTitle);
				cart.removeMedia(searchTitle);
				cart.print();
				seeCurrentCart();
				break;
			}
			case 4: {
				System.out.println("Enter the title: ");
				input.nextLine();
				String inputTitle = input.nextLine();
				Media searchTitle = cart.searchTitle(inputTitle);
				playMedia(searchTitle);
				seeCurrentCart();
				break;
			}
			case 5: {
				cart.print();
				System.out.println("An order is created");
				System.out.println("The full price: " + cart.totalCost());
				cart.getItemsOrdered().clear();
				break;
			}
			case 0: {
				viewStore();
				break;
			}
		}
	}

	public static void updateStore(){
		System.out.println("Enter method: ");
		String method = input.nextLine();
		if (method.equals("Add")){
			System.out.println("Enter type of media: ");
			String type = input.nextLine();
			addMediaToStore(type);
			store.print();
		}
		else if (method.equals("Remove")){
			System.out.println("Enter media title: ");
			String inputTitle = input.nextLine();
			Media searchTitle = store.searchTitle(inputTitle);
			store.removeMedia(searchTitle);
			store.print();
		}
		else {
			System.out.println("Invalid input");
		}
	}

	public static void addMediaToStore(String type){
		int id;
		String title;
		String category;
		float cost;
		int length;
		String director;
		String artist;
		List<Track> tracks = new ArrayList<Track>();
		List<String> authors = new ArrayList<String>();

		if (type.equals("DVD")){
			System.out.println("Enter DVD id: ");
			id = input.nextInt();
			System.out.println("Enter DVD title: ");
			input.nextLine();
			title = input.nextLine();
			System.out.println("Enter DVD category: ");
			category = input.nextLine();
			System.out.println("Enter DVD cost: ");
			cost = input.nextFloat();
			System.out.println("Enter DVD length: ");
			length = input.nextInt();
			System.out.println("Enter DVD director: ");
			input.nextLine();
			director = input.nextLine();

			DigitalVideoDisc media = new DigitalVideoDisc(id, title, category, cost, length, director);
			store.addMedia(media);
		}
		else if (type.equals("CD")){
			String breakpoint = "";
			System.out.println("Enter CD id: ");
			id = input.nextInt();
			System.out.println("Enter CD title: ");
			input.nextLine();
			title = input.nextLine();
			System.out.println("Enter CD category: ");
			category = input.nextLine();
			System.out.println("Enter CD cost: ");
			cost = input.nextFloat();
			System.out.println("Enter CD director: ");
			input.nextLine();
			director = input.nextLine();
			System.out.println("Enter CD artist: ");
			artist = input.nextLine();
			System.out.println("Enter track list: ");

			CompactDisc media = new CompactDisc(id, title, category, cost, director, artist);

			while (!breakpoint.equals("#")){
				System.out.println("Enter track name: ");
				String trackName = input.nextLine();
				System.out.println("Enter track length: ");
				int trackLength = input.nextInt();
				Track track = new Track(trackName, trackLength);
				media.addTrack(track);
				System.out.println("Enter anything to continue adding, enter # to end adding");
				input.nextLine();
				breakpoint = input.nextLine();
			}

			store.addMedia(media);
		}
		else if (type.equals("Book")){
			String breakpoint = "";
			System.out.println("Enter Book id: ");
			id = input.nextInt();
			System.out.println("Enter Book title: ");
			input.nextLine();
			title = input.nextLine();
			System.out.println("Enter Book category: ");
			category = input.nextLine();
			System.out.println("Enter Book cost: ");
			cost = input.nextFloat();
			System.out.println("Enter authors: ");
			input.nextLine();
			Book media = new Book (id, title, category, cost);

			while (!breakpoint.equals("#")){
				System.out.println("Enter author name: ");
				String authorName = input.nextLine();
				media.addAuthor(authorName);
				System.out.println("Enter anything to continue adding, enter # to end adding");
				breakpoint = input.nextLine();
			}

			store.addMedia(media);
		}
		else{
			System.out.println("Invalid input");
		}
	}

	public static Cart cart = new Cart();
	public static List<Media> itemsInCart = cart.getItemsOrdered();
	public static Store store = new Store();
	public static List<Media> itemsInStore = store.getItemsInStore();

	public static void mainMenu() {
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			showMenu();
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
		} while (choice > 3 || choice < 0);
		switch (choice){
			case 1: {
				store.print();
				viewStore();
				break;
			}
			case 2: {
				updateStore();
				mainMenu();
				break;
			}
			case 3: {
				cart.print();
				seeCurrentCart();
				break;
			}
			case 0: {
				break;
			}
		}
	}

	public static void main(String[] args){
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		store.addMedia(dvd1);
		CompactDisc cd2 = new CompactDisc(2, "Star Wars", "Science Friction", 24.95f, "Director 1", "Artist 1");
		CompactDisc cd4 = new CompactDisc(4, "Star Wars 2", "Science Friction", 18.99f);
		Track track1 = new Track("Track1", 50);
		cd2.addTrack(track1);
		Track track2 = new Track("Track2", 40);
		cd2.addTrack(track2);
		Track track3 = new Track("Track3", 20);
		cd2.addTrack(track3);
		cd4.addTrack(track3);
		store.addMedia(cd2);
		store.addMedia(cd4);
		Book book3 = new Book(3, "Aladin", "Animation", 18.99f);
		Book book5 = new Book(5, "Aladin 2", "Animation", 15.32f, "Author 3", "Author 4");
		book3.addAuthor("Author 1");
		book5.addAuthor("Author 2");
		store.addMedia(book3);
		store.addMedia(book5);
		mainMenu();
	}
}

