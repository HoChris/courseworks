package src.peopleprog;

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
	private String clStand;
	private String obType;
	private Address address;
	private PhoneNumber phones;
	private int peopleCount,studentsCount,empCount,staffCount,facCount,
				frman,soph,jun,sen,grads;
	private double salary;
	private ArrayList<PhoneNumber>allPhones = new ArrayList<PhoneNumber>();

//	for nothing in
	public Person(){
		this.firstName = "Sam";
		this.lastName = "Mas";
		this.emailAdd = "hxb@earthlink.com";
		this.address = new Address();
		this.phones = new PhoneNumber();
		//ArrayList<PhoneNumber>pNum = new ArrayList<>();
		this.obType = "blank";
		this.peopleCount=0;
		this.studentsCount=0;
		this.empCount=0;
		this.staffCount=0;
		this.facCount=0;
		this.frman =0;
		this.soph=0;
		this.jun=0;
		this.sen=0;
		this.grads=0;
		this.salary=0.0;

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
		setObType("people");
		setPeopleCount();//adds one to the people count every call
//		System.out.println("construct employee adn phones");
	}

	public Person(String inFirstName, String inLastName,Address inAddress,
				  String inEmailAdd,ArrayList<PhoneNumber>pNum) {
		this.firstName = inFirstName;
		this.lastName = inLastName;
		this.emailAdd = inEmailAdd;
		this.address = inAddress;
		this.storeNums = listPhones(pNum);//passing arraylist from PhoneNumber
		setObType("people");//set the objtype
		setPeopleCount();//adds one to the people count every call

	}
	//constructor cvs style
	public Person(String[] intokens) {
//		PhoneNumber p = new PhoneNumber();
		this.firstName = intokens[1];
		this.lastName = intokens[2];
		Address add1 = new Address(Integer.parseInt(intokens[3]),Integer.parseInt(intokens[4]),
				intokens[5],intokens[6],intokens[7],Integer.parseInt(intokens[8]));
		this.address = add1;
		this.emailAdd = intokens[9];
		//I have to add the phones in after it goes to new line
		//PhoneNumber p = new PhoneNumber().getPassPhone();//calls from phone
//		allPhones.add(p.getPassPhone());
//		this.storeNums = listPhones(allPhones);//passing arraylist from PhoneNumber
		setObType("people");//set the objtype
		setPeopleCount();//adds one to the people count every call

	}
	public Person(Person o){
		Person now = new Person();
		now = o ;
		this.storeNums = listPhones(getAllPhones());
		setObType("people");
		setPeopleCount();

	}
	public String listPhones(ArrayList<PhoneNumber>pNum){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<pNum.size(); i++){
			sb.append(pNum.get(i));
		}
		return sb.toString();
	}
	public	void inThruCvs(PhoneNumber inPhone){
		this.phones = inPhone;
	}

	public String getPhones(){
		return this.storeNums;
	}

	public ArrayList<PhoneNumber> getAllPhones() {
		return allPhones;
	}
	public void setAllPhones(ArrayList<PhoneNumber> allPhones) {
		this.allPhones = allPhones;
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

	public String getObType(){return obType;}
	public void setObType(String obType){this.obType = obType;}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary){this.salary = salary;}

	public String getClStand(){
		return clStand;
	}
	public void setClStand(String s){
		this.clStand = s;
	}

	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(){
		this.peopleCount+=1;
	}

	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(){
		this.empCount+=1;
	}

	public int getStudentsCount() {
		return studentsCount;
	}
	public void setStudentsCount(){
		this.studentsCount+=1;
	}

	public int getStaffCount() {
		return staffCount;
	}
	public void setStaffCount(){
		this.staffCount+=1;
	}

	public int getFacCount() {
		return facCount;
	}
	public void setFacCount(){
		this.facCount+=1;
	}

	public int getFrman() {
		return frman;
	}
	public void setFrman() {
		this.frman+=1;
	}

	public int getSoph() {
		return soph;
	}
	public void setSoph() {
		this.soph +=1;
	}

	public int getJun() {
		return jun;
	}
	public void setJun() {
		this.jun+=1;
	}

	public int getSen() {
		return sen;
	}
	public void setSen() {
		this.sen+=1;
	}

	public int getGrads() {
		return grads;
	}
	public void setGrads() {
		this.grads+=1;
	}


	public String toString() {
		return "----------------------\nName:\t\t\t\t" + getFirstName() +" "+ getLastName()+"\n"+
				"Email:\t\t\t\t" + getEmailAdd() + "\n" + address.toString()+
				"\nPhone Number(s):" + getPhones();
	}
}
