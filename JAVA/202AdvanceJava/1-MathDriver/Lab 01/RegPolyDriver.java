package dapakage;

import java.util.Scanner;

public class RegPolyDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Hello and Welcome to the exciting world of Polygons.\n" +  
		 "Please enter the number of sides first, then enter the length of that side: ");
		
			RegularPolygon daPolygon = new RegularPolygon();
			
			daPolygon.setNumSides(input.nextInt());
			daPolygon.setLength(input.nextDouble());
			System.out.println(" The number of sides: " + daPolygon.getNumSides()); 
			System.out.println(" The length of sides: " + daPolygon.getLength());
			System.out.println("\n The Area : "+ daPolygon.getArea());
			System.out.println(" The Perimeter: " + daPolygon.getPerimeter());
	}

}
