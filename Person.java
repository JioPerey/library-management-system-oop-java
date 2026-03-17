// create a parent class, so that whenever there's other role
// in the future such as Librarian and Administrator we just 
// extend this class because that will also has name and sex.
public class Person {
	protected String name;
	protected String sex;
	
	// Constructor
	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public String getSex() {
		return this.sex;
	}
	
}
