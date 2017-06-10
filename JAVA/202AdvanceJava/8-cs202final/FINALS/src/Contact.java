
//DO NOT TOUCH THIS FILE!!
public class Contact {
	private String lastName;
	private String firstName;
	private long phoneNumber;
	private String email;
	
	public Contact(String lastName, String firstName, long phoneNumber, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String toString() {
		String out = "";
		
		out += "Name:\t" + this.lastName + ", " + this.firstName + "\n";
		out += "Phone:\t" + this.phoneNumber + "\n";
		out += "Email:\t" + this.email + "\n";
		
		return out;
	}
}