package dapakage;

public class Fraction {

	private int numerator;
	private int denomenator;

	
	
	public Fraction(){
		this.numerator = 0;
		this.denomenator = 0;


	}
	public Fraction(int numerator, int denomenator){
		this.numerator = numerator;
		this.denomenator = denomenator;	
	}

	public void doReduce(){	
		int gcf=0;

		gcf = this.numerator%this.denomenator;
		this.numerator=this.numerator/gcf;
		this.denomenator=this.denomenator/gcf;
	
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenomenator() {
		return denomenator;
	}
	public void setDenomenator(int denomenator) {
		this.denomenator = denomenator;
	}

	public String toString() {
		return "The Fraction is " + numerator + "/"
				+ denomenator;
	}
	
	
}
