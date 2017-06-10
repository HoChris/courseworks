package combuilder;

public class HardDrive {

	private String name;
	private int size;
	private double price;
	
	public HardDrive(){
		name = "Default HardDrive";
		size = 0;
		price = 0.0;
		
	}
	

	public HardDrive(String name, int size, double price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}


	public String getName() {
		return this.name;
	}


	public int getSize() {
		return this.size;
	}

	public double getPrice() {
		return this.price;
	}

	
	public String toString() {
		return "HardDrive" + getName() + "\n\tSize: " + getSize() + "GB" + "\n\tPrice:.........................$" + getPrice();
	}
	

}
