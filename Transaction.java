import java.util.List;

public class Transaction {
	private int transactionId;
	private Student studentPerformed;
	private String activityType; // BORROW or RETURN
	private List<Book> booksInvolved;
	
	private static int idTracker = 1;
	
	// Constructor
	Transaction(Student studentPerformed, String activityType, List<Book> booksInvolved) {
		this.transactionId = idTracker++;
		this.studentPerformed = studentPerformed;
		this.activityType = activityType;
		this.booksInvolved = booksInvolved;
	}
	
	// Getters
	public int getTransactionId() {
		return this.transactionId;
	}
	
	public Student getStudentPerformed() {
		return this.studentPerformed;
	}
	
	public String getActivityType() {
		return this.activityType;
	}
	
	public List<Book> getBooksInvolved() {
		return this.booksInvolved;
	}
	
}
