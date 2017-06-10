import java.util.ArrayList;

public class GenericMethods {

	public static void main(String[] args) {
	
	Integer[]numbers = {7,4,2,4,1,5};
	print(numbers);
	sort(numbers);
	print(numbers);
	
		if(linearSearch(numbers, 3) == 0){
		System.out.println("number found!");
		}
		else{
			System.out.println("number not found");
		}
	
	}
	public static <E> void print(E[] list){
		for(int i = 0; i < list.length; i++){
	
			System.out.print(list[i] + " ");
		}
			System.out.println();
	}
	
	public static <E extends Comparable<E>> void sort(E[] list){
		E currentMin;
		int currentMinIndex;

		for(int i=0; i < list.length -1; i++){
			currentMin = list[i];
			currentMinIndex = i;
			
			for(int j=i +1; j < list.length; j++){

				if (currentMin.compareTo(list[j])>0){
					currentMin = list[j];
					currentMinIndex = j;
				}

			}

			if(currentMinIndex != i){
				list[currentMinIndex] = list[i];
				list[i] =currentMin;
			}

		}
}
	public static <E> ArrayList<E> removeDup(ArrayList<E> list){
	// implement the method can void this aswell
		ArrayList<E> temp = (ArrayList<E>) new ArrayList<Object>();
		temp.addAll(list);
		return (ArrayList<E>)temp;
	}

	public static <E extends Comparable<E>> E max(E[] list){
	
	//implement the body
		return list[0];
	}
	
	public static <E extends Comparable<E>> int	binarySearch(E[] list, E key){
		int low = 0, high = list.length -1;
		int mid = (high + low)/2;
		
		while (low < high){
		// use compareTo Method
			int result = key.compareTo(list[mid]);
			if (result<0) {
				high = mid -1;
			}
		
			else if (result == 0){
				return mid;
			}
		
			else{
				low = mid + 1;
			}
				mid = (low + high)/2;
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> E max(E[][] list){

		//implement the body

		E temp = list[0][0];

		 

		return temp;

		}
	
	public static <E> void shuffle(ArrayList<E> list){

		//implement the body

		}

	public static <E extends Comparable<E>> E max(ArrayList<E> list){

	// implement the body

	 

	return list.get(0);

	}
	public static <E extends Comparable<E>> int	linearSearch(E[] list, E key){
	//implement the body
		for (int i=0; i < list.length; i++){
			if(list[i].compareTo(key) == 0){
				return i;
			}
			else{
				return 1;
			}
		}
		return -1;
	}
	
}
	
	 
