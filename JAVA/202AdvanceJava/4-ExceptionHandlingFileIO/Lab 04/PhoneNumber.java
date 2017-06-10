package src.peopleprog;


import java.util.ArrayList;

//The PhoneNumber Class
//•
//A phone number has a type (cell phone, home phone, business, etc...), an area code, prefix, and suffix 
//Example: 323-343-1234, 323 is the area code, 343 is the prefix, 1234 is the suffix.
public class PhoneNumber {
	private String type;
	private int areaCode;
	private int prefix;
	private int suffix;
	private static ArrayList<PhoneNumber> pNum = new ArrayList<PhoneNumber>();
	private PhoneNumber passPhone;

	public PhoneNumber() {
		this.type = "not set";
		this.areaCode = 909;
		this.prefix = 998;
		this.suffix = 1234;
	}

	public PhoneNumber(String inType, int inAreacode, int inPrefix, int inSuffix) {
		PhoneNumber p1 = new PhoneNumber();

		this.type = inType;
		this.areaCode = inAreacode;
		this.prefix = inPrefix;
		this.suffix = inSuffix;
		p1.setType(this.type);
		p1.setAreaCode(this.areaCode);
		p1.setPrefix(this.prefix);
		p1.setSuffix(this.suffix);
		pNum.add(p1);
	}
	//construct cvs style
	public PhoneNumber(String[] intokens) {
		PhoneNumber p1 = new PhoneNumber();

		this.type = intokens[1];
		this.areaCode = Integer.parseInt(intokens[2]);
		this.prefix = Integer.parseInt(intokens[3]);
		this.suffix = Integer.parseInt(intokens[4]);
		p1.setType(this.type);
		p1.setAreaCode(this.areaCode);
		p1.setPrefix(this.prefix);
		p1.setSuffix(this.suffix);
		this.passPhone = p1;
	}

	public String getType() {
		return this.type;
	}

	public int getAreaCode() {
		return this.areaCode;
	}

	public int getPrefix() {
		return this.prefix;
	}

	public int getSuffix() {
		return this.suffix;
	}

	public void setPassPhone(PhoneNumber inphone){this.passPhone = inphone;}
	public PhoneNumber getPassPhone(){return this.passPhone;}

	public void setType(String type) {
		this.type = type;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(int suffix) {
		this.suffix = suffix;
	}

	public static ArrayList<PhoneNumber> getpNum() {
		return pNum;
	}


	@Override
	public String toString() {
		return "    " + getType() + ":   (" + getAreaCode() +") "+
				getPrefix() + "-" + getSuffix()+ "\n\t\t\t\t";
	}


}