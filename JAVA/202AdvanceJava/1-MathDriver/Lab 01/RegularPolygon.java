package dapakage;


public class RegularPolygon {

    private int numSides;
    private double length;

    public RegularPolygon(){
    	this.numSides = 3;
    	this.length = 1.0;
    	
    }

	public RegularPolygon(int numSides, double length) {

		this.numSides = numSides;
		this.length = length;
	}
	public double getPerimeter(){
		
		return  this.numSides * this.length;
		
	}
	public double getArea(){
		
		return ((this.numSides * Math.pow(this.length,2)) / 4 * Math.tan(Math.PI/this.numSides));
		
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		if (numSides > 3 && numSides==(int)numSides) {
			this.numSides = numSides;
		} else {
			System.out.println("Somethings wierd. Reverting to Default.");
		}
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0 && length == (double)length ) {
			this.length = length;
		}	
		else{
			
		}

	}	
}
