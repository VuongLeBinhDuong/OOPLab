package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors() {
		return authors;
	}
	public Book(int id, String title, String category, float cost, String... authors) {
        super(id, title, category, cost);
        for (String author : authors) {
            this.authors.add(author);
        }
    }

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public void addAuthor(String author) {
		if (!authors.contains(author)) {
			authors.add(author);
		}
		else {
			System.out.println("The author is already in the list");
		}
	}
	public void removeAuthor(String author) {
		if (authors.contains(author)) {
			authors.remove(author);
		}
		else {
			System.out.println("The author is not in the list");
		}
	}
	
	@Override
    public String toString() {
        return "Book: " + super.toString() + " - "+ getAuthors();
    }
	
}
