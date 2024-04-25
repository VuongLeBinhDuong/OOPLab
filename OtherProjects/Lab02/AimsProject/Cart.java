
public class Cart {
	public final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
			if (MAX_NUMBERS_ORDERED - qtyOrdered <= 1) {
				System.out.println("The cart is almost full");
			}
		}
		else {
			System.out.println("The cart is full, cannot add any more disc");
		}
		return;
	}
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                itemsOrdered[qtyOrdered - 1] = null; 
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
		}
		System.out.println("No disc found");
	}
	public void displayCart () {
		System.out.println("The cart includes: ");
		for (int i=0;i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getTitle());
		}
		return;
	}
	public float totalCost () {
		float sum = 0;
		for (int i=0;i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}
