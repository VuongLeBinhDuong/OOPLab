package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public Media() {

    }
	public Media (int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media (int id, String title) {
		this.id = id;
		this.title = title;
	}
	public boolean isMatch(String title){
        return Objects.equals(this.getTitle(), title);
    }
	@Override
    public String toString() {
        return getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media that)) return false;
        return Objects.equals(getTitle(), that.getTitle());
    }
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
