
public class BinarySearch {
	int key;
	public static void main(String[] args) {
		int[]numbers = new int[7];
		numbers[0]= 2;
		numbers[1]= 13;
		numbers[2]= 7;
		numbers[3]= 9;
		numbers[4]= 23;
		numbers[5]= 0;
		numbers[6]= 6;
		
		System.out.println("before selection sort");
		for (int x:numbers){
			System.out.println(x);
		}
		
		selectionSort(numbers);
		System.out.println("After selection sort");
		for(int i=0;i<numbers.length;i++){
			System.out.println(numbers[i]);
		}
		isIn(searchBinary(numbers, 13));
		
		 
		
		
}
	
	public static int recursiveBinarySearch(int[] list, int key) {
	 int low = 0;
	 int high = list.length - 1;
	 return recursiveBinarySearch(list, key, low, high);
	}

	public static int recursiveBinarySearch(int[] list, int key,
	 int low, int high) {
		
		if (low > high) // The list has been exhausted without a match
			return -low - 1;
	 int mid = (low + high) / 2;
	 	if (key < list[mid])
	 		return recursiveBinarySearch(list, key, low, mid - 1);
	 	else if (key == list[mid])
	 		return mid;
	 	else
	 		return recursiveBinarySearch(list, key, mid + 1, high);
	}

	public static void sort(Double[] list, int low, int high){
		if (low < high){
			int indexOfMin = low;
			Double min = list[low];
			for(int i = low + 1; i <=high; i++){
				if(list[i] < min){
					min = list[i];
					indexOfMin = 1;
					}
				}
			//swap the smallest in list
			list[indexOfMin] = list[low];
			list[low] = min;
			//recursive call
			sort(list, low + 1, high);
			}
		}
//non recursive sort
	public static void selectionSort(int[] numbers) {
	    int i, j, lowNum, tmp;
	    int n = numbers.length;
	    for (i = 0; i < n - 1; i++) {
	          lowNum = i;
	          for (j = i + 1; j < n; j++)
	                if (numbers[j] < numbers[lowNum])
	                      lowNum = j;
	          if (lowNum != i) {
	                tmp = numbers[i];
	                numbers[i] = numbers[lowNum];
	                numbers[lowNum] = tmp;
	          }
	    }
	}
	//non recusive method
	public static int searchBinary(int[]numbers, int key){
		
		int low = 0;
		int high = numbers.length -1;
		
		while (high > low){
			int mid = (low + high) /2;
			if (key < numbers[mid])
				high = mid - 1;
			else if (key == numbers[mid])
				return mid;
			else 
				low = mid + 1;
		}
		
		return -low -1;
	}
	public static void isIn(int x){
		if(x < 0){
			System.out.println("Number not found");
		}
		else{
			System.out.println( x + " position in the sorted list.");
		}
	}
}
