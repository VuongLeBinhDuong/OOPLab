package AimsProject.hust.soict.ict.aims.cart;

import java.util.ArrayList;
import AimsProject.hust.soict.ict.aims.media.Media;
import java.util.List;

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>();
	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void addMedia(Media media){
        if(!itemsOrdered.contains(media)){
            itemsOrdered.add(media);
        }
        else {
            System.out.println("The item is already in the ordered list");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
        }
        else {
            System.out.println("The item is not in the ordered list");
        }
    }
	public float totalCost () {
		float sum = 0;
		for (int i=0;i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (int i=0;i < itemsOrdered.size();i++) {
			System.out.printf("%d. ", i+1);
			System.out.printf(itemsOrdered.get(i).toString());
			System.out.printf("\n");
		}
		System.out.println("***************************************************");
	}
	public Media searchTitle(String title) {
		int cnt = 0;
		Media item = new Media();
		for (int i=0;i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(title)) {
				cnt++;
				return itemsOrdered.get(i);
			}
		}
		if (cnt == 0) {
			System.out.println("No item is found");
		}
		return item;
	}

	public Media searchId(int Id) {
		int cnt = 0;
		Media item = new Media();
		for (int i=0;i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == Id) {
				cnt++;
				return itemsOrdered.get(i);
			}
		}
		if (cnt == 0) {
			System.out.println("No item is found");
		}
		return item;
	}
}

