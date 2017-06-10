package dapakage;

import java.util.Scanner;

public class FracDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Fraction f1 = new Fraction();
		
		Fraction f2 = new Fraction();
		
		System.out.println(20%40);
		
		
		f1.setDenomenator(60);
		f1.setNumerator(15);
		f1.doReduce();
		System.out.println(f1.toString());
		
		f2.setDenomenator(40);
		f2.setNumerator(20);
		f2.doReduce();
		System.out.println(f2.toString());
		
		
	}

}
