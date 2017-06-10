package weekonelab;


public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Reverse Number: ");
		reverseDisplay(1234);
		System.out.print("\nReverse Word: ");
		reverseDisplay("hello");
		System.out.print("\nReverse Word no index: ");
		reverseDisplay2("hi");
	}
	
	//for displaying reverse numbers
	public static void reverseDisplay(int value){
		if (value < 10){
			System.out.print(value);
		}
		else {
			System.out.print(value%10);
			reverseDisplay(value/10);
		}
		
	}
	
	//for displaying reverse order of string
	public static void reverseDisplay(String value){
		reverseDisplay(value, value.length());
	}
	//with index method
	public static void reverseDisplay(String value,int index){
		if(index > 0 ){
			System.out.print(value.charAt(index - 1));
			reverseDisplay(value, index - 1);
		}
		
	}
	//with out index method
	public static void reverseDisplay2(String value){
		if(value.length() == 1 ){
			System.out.print(value);
		}
		else {
			System.out.print(value.substring(1) + value.charAt(0));
		}
	}
	
}
