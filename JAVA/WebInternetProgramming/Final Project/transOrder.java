package lastInventory;

public class transOrder {

	int id;
	String order;
	
	
	public transOrder(int id, String order) {
		super();
		this.id = id;
		this.order = order;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
