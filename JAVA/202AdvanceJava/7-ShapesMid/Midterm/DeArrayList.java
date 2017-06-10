package DaShapes;

import java.util.ArrayList;

public class DeArrayList {

	private ArrayList<Shape3D>listShapes;
	
	public DeArrayList(){
		
		ArrayList<Shape3D> a1 = new ArrayList<Shape3D>();
		ArrayList<Shape3D> a2 = new ArrayList<Shape3D>();
		
		Pyramid q1= new Pyramid(blue, 2.4, 1.4, 12.2);
		Pyramid q2= new Pyramid(red, 34.2, 22.1, 12.2);
		Pyramid q3= new Pyramid(black, 6.3, 7.0, 3.0);
		Pyramid q4= new Pyramid(brown, 1.0, 2.0, 3.0);
		Pyramid q5= new Pyramid(yellow, 5.0, 5.0, 5.0);
			
		Cylinder t1 = new Cylinder(blue, 2.0, 2.0);
		Cylinder t2 = new Cylinder(black, 5.0, 2.5);
		Cylinder t3 = new Cylinder(yellow, 1.0,1.0);
		Cylinder t4 = new Cylinder(red, 4.5,5.5);
		Cylinder t5 = new Cylinder(green, 7.0, 8.0);
		
		a1.add(q1);
		a1.add(q5);
		a1.add(q4);
		a1.add(q3);
		a1.add(q2);
		
		a1.add(t5);
		a1.add(t3);
		a1.add(t2);
		a1.add(t1);
		a1.add(t4);
		
		listShapes.equals(a1);
	
	}

	public ArrayList<Shape3D> getListShapes() {
		return listShapes;
	}
	
}
