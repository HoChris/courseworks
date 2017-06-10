package DaShapes;

public class Pyramid extends Shape3D{
	private double base;
	private double height;
	private double slant;
	
	public Pyramid(String color, double base,
			double height, double slant) {
		super(color);
		this.base = base;
		this.height = height;
		this.slant = slant;
		
	}

	@Override
	public String toString() {
		return "Pyramid Base: " + getBase() + "/n Height: " + getHeight() +
				"/n Slant: " + getSlant();
	}

	
	@Override
	public double area() {
		double pyrArea = (2 * this.base * this.slant) +
				this.base * this.base;
		return pyrArea;
	}

	@Override
	public double volume() {
		double pyrVolume = ((1 / 3) * this.base * this.base *
				this.height);
		return pyrVolume;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	public double getSlant() {
		return slant;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setSlant(double slant) {
		this.slant = slant;
	}
	
	
}
