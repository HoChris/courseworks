import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class ContactList extends ArrayList<Contact> {

	//Make an empty contact list
	public ContactList() {
		super();
	}
	
	//Takes an input file and parses it, adding each
	//contact to the contact list object.
	public ContactList(File inputFile) throws FileNotFoundException {
		//!!!Code for parsing the input file goes here!!!
		Scanner reader = new Scanner(inputFile);
		while (reader.hasNext()) {
			String daLine = reader.nextLine();
			String[] tokens = daLine.split(",");
			Contact someContact = new Contact(
					tokens[0],tokens[1],Long.parseLong(tokens[2]),tokens[3]);
			this.add(someContact);
		}
		reader.close();
	}
	
	public void addContact(Contact c) {
		super.add(c);
	}
	
	public String toString() {
		String result = "";
		
		for (Contact c: this) {
			result += c + "\n";
		}
		
		return result;
	}
}
