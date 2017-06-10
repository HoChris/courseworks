package DaShapes;

public abstract class Shape3D {
 private String color;
 
 	protected Shape3D(String color){
 		this.color = color;
 	};
 	
 	
 	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	public abstract double area();
	public abstract double volume();
}
