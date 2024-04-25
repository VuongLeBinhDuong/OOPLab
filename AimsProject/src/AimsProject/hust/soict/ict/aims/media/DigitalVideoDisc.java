package AimsProject.hust.soict.ict.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(int id, String title) {
		super(id, title);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost, director);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director ) {
		super(id, title, category, cost, length, director);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public String toString() {
		return "DVD: " + super.toString();
	}
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DigitalVideoDisc that)) return false;
        return getLength() == that.getLength() && Float.compare(getCost(), that.getCost()) == 0 && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getDirector(), that.getDirector());
    }
}
