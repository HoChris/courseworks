package Store;

public class storeItem {
	
	
	static int count = 0;
	
	int id;
	Double price;
	int quantity;
	String name;
	String description;
	
	
	public storeItem(Double price, int quantity, String name, String description) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.id = count++;
	}
	public storeItem() {
		super();
		this.price = 0.;
		this.quantity = 0;
		this.name = "";
		this.description = "";
		this.id = count++;
	}

	public int getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
