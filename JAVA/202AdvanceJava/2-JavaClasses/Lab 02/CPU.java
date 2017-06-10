package combuilder;

public class CPU {

	private String name;
	private double speed;
	private double price;
	
	public CPU(){
		name = "Default CPU";
		speed = 0.0;
		price = 0.0;
	}
	
	public CPU(String name, double speed, double price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getPrice() {
		return this.price;
	}

	public String toString() {
		return "CPU " + getName() + "\n\tSpeed: " + getSpeed() + "GHz" + "\n\tPrice:.........................$" + getPrice();
	}
	
	
}
