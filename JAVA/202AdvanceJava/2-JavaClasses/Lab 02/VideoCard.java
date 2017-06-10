package combuilder;

public class VideoCard {

	private String name;
	private int memorySize;
	private double price;
	
	public VideoCard(){
		name = "Default Generic Video Card";
		memorySize = 0;
		price = 0.0;
	}
	
	public VideoCard(String name, int memorySize, double price){
		this.name = name;
		this.memorySize = memorySize;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getMemorySize() {
		return this.memorySize;
	}

	public double getPrice() {
		return this.price;
	}


	public String toString() {
		return "Video Card " + getName() + "\n\tSize: " + getMemorySize()+ "GB" + "\n\tPrice:.........................$" + getPrice();
	}
	
	
}
