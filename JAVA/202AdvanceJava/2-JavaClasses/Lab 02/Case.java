package combuilder;

public class Case {

	private String name;
	private double height;
	private double width;
	private double depth;
	private String type;
	private double price;
	
	public Case(){
		this.name = "Default Generic Case";
		this.height = 0.0;
		this.width = 0.0;
		this.depth = 0.0;
		this.type = "Medium";
		this.price = 0.0;
	}
	
	public Case(String name, double height, double width, double depth, String type, double price) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.type = type;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

	public double getDepth() {
		return this.depth;
	}

	public String getType() {
		return this.type;
	}

	public double getPrice() {
		return this.price;
	}


	public String toString() {
		return "Case "+ getName() + "\n\tDimensions: " + getDepth() + "\" x" + getWidth() + "\" x" + getHeight() +
				"\"" + "\n\tType: " +  getType() + "\n\tPrice:.........................$" + getPrice();
	}
	
	
}
