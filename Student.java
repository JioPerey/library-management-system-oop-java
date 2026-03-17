import java.util.ArrayList;
import java.util.List;

// subclass of Person Class
public class Student extends Person{
	private int studentId;
	private String academicProgram;
	private List<Transaction> activityLog;
	
	private static int idTracker = 1;
	
	// Constructor
	Student(String name, String sex, String academicProgram) {
		super(name, sex);
		this.studentId = idTracker++;
		this.academicProgram = academicProgram;
		this.activityLog = new ArrayList<>();
	}
	
	// Getters
	public int getStudentId() {
		return this.studentId;
	}
	
	public String getAcademicProgram() {
		return this.academicProgram;
	}
	
	public List<Transaction> getActivityLog() {
		return this.activityLog;
	}
	
	// Methods
	// Method that let the Student borrow book/s
	public void borrowBooks(Library library, List<Book> booksToBorrow) {
		System.out.println("Borrowing books...");
		for (int index = 0; index < booksToBorrow.size(); index++) {
			Book currentBook = booksToBorrow.get(index);
			// Check each book if the library has it
			// If not available, it displays a message and cancel the book borrowing
			if (!library.hasBookOf(currentBook)) {
				System.out.println("The library doesn't have a \"" + currentBook.getTitle() + "\"." );
				System.out.println("Book borrowing cancelled.");
				return;
			}
			
			// Check if bookToBorrow is available (not currently borrowed)
			// If not available, it displays a message and cancel the book borrowing
			if (!currentBook.isAvailable()) {
				System.out.println("\"" + currentBook.getTitle()  + "\" is currently unavailable." );
				System.out.println("Please try again later.");
				return;
			}
			
			currentBook.setIsAvailable(false);
		}
		
		// Create instance of Transaction so that we can have a history
		Transaction newTransaction = new Transaction(this, "BORROW", booksToBorrow);
		// Student keeps a record of their activities
		this.activityLog.add(newTransaction);
		// Library keeps a record of activities
		library.addActivity(newTransaction);
					
		
		System.out.println("\"" + this.getName() + "\" successfully borrowed some books!" );
		System.out.println("Books borrowed:");
		for (int index2 = 0; index2 < booksToBorrow.size(); index2++) {
			Book currentBook = booksToBorrow.get(index2);
			System.out.println((index2  + 1) + ". " + currentBook);
		}
	}
	
	// Method that let the Student return book/s
	public void returnBooks(Library library, List<Book> booksToReturn) {
		System.out.println("Returning books...");
		for (int index = 0; index < booksToReturn.size(); index++) {
			Book currentBook = booksToReturn.get(index);
			// Check each book if the library has it
			// Student can't return a book that doesn't belong to the library
			if (!library.hasBookOf(currentBook)) {
				System.out.println("The library doesn't have a \"" + currentBook.getTitle() + "\"." );
				System.out.println("Book returning cancelled.");
				return;
			}
			
			// Check if bookToReturn is actually borrowed by the student
			// If the isAvailable flag is true, meaning it is currently not borrowed
			// It doesn't make sense if the Student is returning a book that isn't borrowed
			if (currentBook.isAvailable()) {
				System.out.println("Invalid book.");
				System.out.println("Book returning cancelled.");
				return;
			}
			
			currentBook.setIsAvailable(true); // set the isAvailable flag to true so that it is available for borrowing again
		}
		
		// Create instance of transaction so that we can have a history
		Transaction newTransaction = new Transaction(this, "RETURN", booksToReturn);
		// Student keeps a record of their activities
		this.activityLog.add(newTransaction);
		// Library keeps a record of activities
		library.addActivity(newTransaction);
					
		
		System.out.println("\"" + this.getName() + "\" successfully returned some books!" );
		System.out.println("Books returned:");
		for (int index2 = 0; index2 < booksToReturn.size(); index2++) {
			Book currentBook = booksToReturn.get(index2);
			System.out.println((index2  + 1) + ". " + currentBook);
		}
	}
	
	// Method for displaying the activity log of a particular Student
	public void printActivityLog() {
		System.out.println("Retrieving activity history of \"" + this.getName() + "\"...");
		
		// Check if the Student has activity
		if (getActivityLog().isEmpty()) {
			System.out.println("\"" + this.getName() + "\" doesn't have any activity yet.");
			return;
		}
		
		// Loop through the Student's activity log
		for (int index = 0; index < getActivityLog().size(); index++) {
			Transaction currentActivity = getActivityLog().get(index);
			
			System.out.println("\nTRANSACTION ID: " + currentActivity.getTransactionId());
			System.out.println("ACTIVITY TYPE: " + currentActivity.getActivityType());
			System.out.println("BOOKS INVOLVED: ");
			for (int index2 = 0; index2 < currentActivity.getBooksInvolved().size(); index2++) {
				Book currentBook = currentActivity.getBooksInvolved().get(index2);
				System.out.println((index2  + 1) + ". " + currentBook);
			}
		}
		
	}
	
}
