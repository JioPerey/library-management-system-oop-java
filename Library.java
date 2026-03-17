
import java.util.ArrayList;
import java.util.List;
public class Library {
	List<Book> books;
	List<Transaction> activitiesHistory;
	
	// Constructor
	Library() {
		this.books = new ArrayList<>();
		this.activitiesHistory = new ArrayList<>();
	}
	
	
	// Getters
	public List<Book> getBooks() {
		return this.books;
	}
	
	public List<Transaction> getActivitiesHistory() {
		return this.activitiesHistory;
	}
	
	// Methods
	// Method that add a Book to the Library
	public void addBook(Book bookToAdd) {
		// Check if Book to be added is valid.
		if (bookToAdd == null) {
			System.out.println("Invalid book.");
			System.out.println("Please add a valid book.");
			return;
		}
		
		this.books.add(bookToAdd);
		System.out.println("Book \"" + bookToAdd.getTitle() +"\" was added to the library.");
	}
	
	// Method that adds activity to activityHistory
	public void addActivity(Transaction transactionToAdd) {
		this.activitiesHistory.add(transactionToAdd);
	}
	
	// Method that checks if the Library has the specified book
	public boolean hasBookOf(Book bookToCheck) {
		return getBooks().contains(bookToCheck);
	}
	
	// Method that displays the activity history of Library
	public void printActivityHistory() {
		System.out.println("Retrieving activities history of library...");
		
		// Check if the Library has activity records
		if (getActivitiesHistory().isEmpty()) {
			System.out.println("Library doesn't have any activity yet.");
			return;
		}
		
		// Loop through the Library's activities history
		for (int index = 0; index < getActivitiesHistory().size(); index++) {
			Transaction currentActivity = getActivitiesHistory().get(index);
			
			System.out.println("\nTRANSACTION ID: " + currentActivity.getTransactionId());
			System.out.println("STUDENT PERFORMED: " + currentActivity.getStudentPerformed().getName());
			System.out.println("ACTIVITY TYPE: " + currentActivity.getActivityType());
			System.out.println("BOOKS INVOLVED: ");
			for (int index2 = 0; index2 < currentActivity.getBooksInvolved().size(); index2++) {
				Book currentBook = currentActivity.getBooksInvolved().get(index2);
				System.out.println((index2  + 1) + ". " + currentBook);
			}
		}
		
	}
	
}
