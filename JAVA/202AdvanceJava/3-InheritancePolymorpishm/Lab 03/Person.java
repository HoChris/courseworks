package peopleprog;

import java.util.ArrayList;

//The Person Class
//•
//A person has a first name, last name, email address, 
//Address, and 1 or more PhoneNumbers
//•
//NOTE: A person can have any number of phone numbers
public class Person {
	private String firstName;
	private String lastName;
	private String emailAdd;
	private String storeNums;
	private Address address;
	public static int people;

//	for nothing in
	public Person(){
		/*this.*/firstName = "Sam";
		/*this.*/lastName = "Mas";
		/*this.*/emailAdd = "hxb@earthlink.com";
		/*this.*/address = new Address();
		//ArrayList<PhoneNumber>pNum = new ArrayList<>();
		people = 0;
		System.out.println("Warning: Generic Info");
	}

//	for incoming data and Phone(s)
//	public Person(Address inAddress,ArrayList<PhoneNumber>pNum,
//				  String inFirstName, String inLastName, String inEmailAdd){
//		this.firstName = inFirstName;
//		this.lastName = inLastName;
//		this.emailAdd = inEmailAdd;
//		this.address = inAddress;
//		this.storeNums = listPhones(PhoneNumber.getpNum());//passing arraylist from PhoneNumber
//		System.out.println("construct phones");
//
//	}
	public Person(Address inAddress,ArrayList<PhoneNumber>pNum,
				  String inFirstName, String inLastName, String inEmailAdd) {
		this.firstName = inFirstName;
		this.lastName = inLastName;
		this.emailAdd = inEmailAdd;
		this.address = inAddress;
		this.storeNums = listPhones(pNum);//passing arraylist from PhoneNumber
		people+=1;
//		System.out.println("construct employee adn phones");
	}
	public String listPhones(ArrayList<PhoneNumber>pNum){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<pNum.size(); i++){
			sb.append(pNum.get(i));
		}
		return sb.toString();
	}
	public String getPhones(){
		return this.storeNums;
		
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public Address getAddress() {
		return address;
	}

	public static int getPeople() {
		return people;
	}

	public String toString() {
		return "----------------------\nName:\t\t\t\t" + getFirstName() +" "+ getLastName()+"\n"+
				"Email:\t\t\t\t" + getEmailAdd() + "\n" + address.toString()+
				"\nPhone Number(s):" + getPhones();
	}
}
