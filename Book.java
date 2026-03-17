
public class Book {
	private int bookId;
	private String title;
	private boolean isAvailable; // flag to track if Book is currently borrowed
	
	private static int idTracker = 1;
	
	// Constructor
	Book(String title) {
		this.bookId = idTracker++;
		this.title = title;
		this.isAvailable = true;
	}
	
	// Getters
	public int getBookId() {
		return this.bookId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	// Setters
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String toString() {
		return this.getTitle() + " [BK" + this.getBookId() + "]"; 
	}
}
