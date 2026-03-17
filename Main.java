import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Creating an instance of the Library
		Library library1 = new Library();
		
		// Creating instances of Book
		Book book1 = new Book("JavaScript Basics");
		Book book2 = new Book("Data Structures");
		Book book3 = null; // Invalid book
		
		// Adding books to the library
		System.out.println("Adding books to the library...");
		library1.addBook(book1);
		library1.addBook(book2);
		library1.addBook(book3);
		
				
		// Creating instances of Student
		Student student1 = new Student("Jio Perey", "Male" , "BSIT");
		Student student2 = new Student("Joshua Garcia", "Male", "BSCS");
		
		// Jio Perey borrowed Book 1 & 2
		System.out.println("\n===== Test Case 1 =====");
		List<Book> booksToBorrow = new ArrayList<>();
		booksToBorrow.add(book1);
		booksToBorrow.add(book2);
		student1.borrowBooks(library1, booksToBorrow);
		
		// Joshua Garcia tries to borrow a book that is currently borrowed by Jio Perey
		System.out.println("\n===== Test Case 2 =====");
		List<Book> booksToBorrow2 = new ArrayList<>();
		booksToBorrow2.add(book1);
		student2.borrowBooks(library1, booksToBorrow2);
		
		// Jio Perey returned Book 1
		System.out.println("\n===== Test Case 3 =====");
		List<Book> booksToReturn = new ArrayList<>();
		booksToReturn.add(book1);	
		student1.returnBooks(library1, booksToReturn);
		
		// Joshua Garcia borrowed Book 1
		System.out.println("\n===== Test Case 4 =====");
		student2.borrowBooks(library1, booksToBorrow2);
		
		// Displaying activity log of Jio Perey
		System.out.println("\n===== Test Case 5 =====");
		student1.printActivityLog();
		
		// Displaying activity log of Joshua Garcia
		System.out.println("\n===== Test Case 6 =====");
		student2.printActivityLog();
		
		// Displaying activity history of Library 1
		System.out.println("\n===== Test Case 7 =====");
		library1.printActivityHistory();
		
		System.out.println("\nDeveloped by Jio Perey");
		System.out.println("03/16/2026");
}

}
