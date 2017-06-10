package DaShapes;

public class Cylinder extends Shape3D {
	private double radius;
	private double height;
	
	public Cylinder(String color,
			double radius, double height) {
		super(color);
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double area() {
		double cylArea = (2 * Math.PI * this.radius * this.radius) +
				(2 * Math.PI * this.radius * this.height);
		return cylArea;
	}

	@Override
	public double volume() {
		double cylVolume = Math.PI * this.radius * this.radius *
				this.height;
		return cylVolume;
	}

	@Override
	public String toString() {
		return "Cylinder : Radius "+getRadius() + "/nHeight : "+ getHeight();
	}

	public double getRadius() {
		return radius;
	}

	public double getHeight() {
		return height;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
