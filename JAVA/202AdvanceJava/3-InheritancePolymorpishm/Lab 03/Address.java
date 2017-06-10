package peopleprog;
//The Address Class• An address has a street number, optional apartment number, street name, city, state, zip code.
public class Address {
	private int streetNumber;
	private int apNumber;
	private String streetName;
	private String city;
	private String state;
	private int zip;
	
	public Address(){//the default
		this.streetNumber = 1234;
		this.apNumber = 0;
		this.streetName = "Seasame Street";
		this.city = "LA";
		this.state = "California";
		this.zip = 90001;
	}

	public Address(int inStreetNumber, int inApNumber, String inStreetName,
			String inCity, String inState, int inZip) {
		this.streetNumber = inStreetNumber;
		this.apNumber = inApNumber;
		this.streetName = inStreetName;
		this.city = inCity;
		this.state = inState;
		this.zip = inZip;
	}
	
	public Address(int inStreetNumber, String inStreetName, String inCity,
			String inState, int inZip) {
		this.streetNumber = inStreetNumber;
		this.streetName = inStreetName;
		this.city = inCity;
		this.state = inState;
		this.zip = inZip;
	}



	public int getStreetNumber() {
		return this.streetNumber;
	}

	public int getApNumber() {
		return this.apNumber;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setApNumber(int apNumber) {
		this.apNumber = apNumber;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		if (getApNumber() > 0){
			return "Address:\t\t\t" +
					getStreetNumber() + " " + getStreetName() + " " +"apt/unit/suite: "+ getApNumber()+
					"\n\t\t\t\t\t"+	getCity() +", "+ getState() +", "+ getZip()+" ";
		}
		return "Address:\t\t\t" +
				getStreetNumber() +" "+ getStreetName() +"\n\t\t\t\t\t"+
				getCity() +", "+ getState() +", "+ getZip()+" ";


	}
}
