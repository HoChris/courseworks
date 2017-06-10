

public class SortingTimes {
	private static Integer[] theArray;

	
	public static void main(String[] args) {
	
		printTable(genTables());
	}
	
	public static Integer[] generateRandomArray(int size){
		theArray = new Integer[size];	
		for(int j = 0; j < theArray.length;j++){
			theArray[j] = (int)(Math.random()*10);
		}
		return theArray;
	}
	
	public static Integer[][] genTables() {
		Integer[] d5 = generateRandomArray(50000 );
		Integer[] d10 =generateRandomArray(100000);
		Integer[] d15 =generateRandomArray(150000);
		Integer[] d20 =generateRandomArray(200000);
		Integer[] d25 =generateRandomArray(250000);
		Integer[] d30 =generateRandomArray(300000);
		Integer[] d35 =generateRandomArray(350000);
		
		Integer[] storeRandoms [] = {d5,d10,d15,d20,d25,d30,d35};
		return storeRandoms;
		
	}
	public static void printTable(Integer[][] table){
		int arraySize = 50000;
		
//		for(Integer[] i : table){
//			System.out.println(selectionSort(i));
//			System.out.println(insertionSort(i));
//			System.out.println(bubbleSort(i));
//			System.out.println(mergeSort(i));
//			System.out.println(quickSort(i));
//			System.out.println(heapSort(i));
//			arraySize += 50000;
//			System.out.println("next");
//		} testing
//		
		System.out.println("Array Size | Selection\t | Insertion\t | Bubble\t | Merge\t | Heap\t | Quick");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		for(Integer[] i : table){
			System.out.printf("%d\t      %d\t\t %d\t\t %d\t\t %d\t     %d\t\t %d \n",
					arraySize, selectionSort(i), insertionSort(i),
					bubbleSort(i), mergeSort(i), heapSort(i), quickSort(i));
			arraySize += 50000;
		}
		
	}
	
	
	
	public static <E extends Comparable<E>> long insertionSort(E[] list){
		long startTime = System.currentTimeMillis();
		for(int i = 1; i < list.length; i++){
			E currentElement = list[i];
			int k;
			for(k = i -1; k >= 0;k--){
				if (list[k].compareTo(currentElement) <=0 ){
					break;
				}
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
		return System.currentTimeMillis() - startTime;
	}
	
	public static <E extends Comparable<E>> long bubbleSort(E[] list){
		long startTime = System.currentTimeMillis();
		for(int i = 1; i < list.length; i++){
			for(int k  = 0; k < list.length - i;k++){
				if(list[k].compareTo(list[k + 1]) >= 0){
					E temp = list[k];
					list[k]=list[k+1];
					list[k+1]= temp;
				}
			}
		}
		return System.currentTimeMillis() - startTime;

	}
	
	public static <E extends Comparable<E>> long mergeSort(E[] list){
		return mergeSort(list, 0, list.length-1);
	}
	
	private static <E extends Comparable<E>> long mergeSort(E[] list, int first, int second) {
		long startTime = System.currentTimeMillis();
		if(second - first < 1)
			return startTime;
		int mid = (first + second)/2;
		mergeSort(list, first, mid);
		mergeSort(list, mid+1, second);
		merge(list,first,mid,second);
		
		return System.currentTimeMillis() - startTime;
	}

	private static <E extends Comparable<E>> void merge(E[] list, int first, int mid, int second) {
		Object[] tmp = new Object[second - first + 1];
		int i = first;
		int j = mid+1;
		int k = 0;
		while (i <= mid && j <= second) {
			if (list[i].compareTo(list[j])<=0)
				tmp[k] = list[i++];
			else
				tmp[k] = list[j++];
			k++;
		}
		if (i <= mid && j > second) {
			while (i <= mid) 
				tmp[k++] = list[i++];
		} else {
			while (j <= second)
				tmp[k++] = list[j++];
		}
		for (k = 0; k < tmp.length; k++) {
			list[k+first] = (E)(tmp[k]);
		}
		
	}
	
	public static<E extends Comparable<E>> long heapSort(E[]list){
		HeapTry<E> heap = new HeapTry<>();
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < list.length; i++){
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--){
			list[i] = heap.remove();
		}
		return System.currentTimeMillis() - startTime;
	} 
	
	public static<E extends Comparable<E>> long selectionSort(E[]list){
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < list.length; i++){
			int minimum = i;
			
			for(int j = i+1; j < list.length; j++){
				if(list[minimum].compareTo(list[j]) > 0){
					minimum = j;
				}
			}
			
			E swap = list[minimum];
			list[minimum] = list[i];
			list[i] = swap;
		}
		return System.currentTimeMillis() - startTime;
	}
	
	public static <E extends Comparable<E>> long quickSort(E[] list){
		return quickSort(list, 0, list.length - 1);
	}
	
	public static <E extends Comparable<E>> long quickSort(E[] list, int first, int last) {
		long startTime = System.currentTimeMillis();
		if(last > first){
	            int i = first, j = last;
	            E x = list[(i + j) / 2];
	 
	            do {
	                while (list[i].compareTo(x) < 0) i++;
	                while (x.compareTo(list[j]) < 0) j--;
	 
	                if ( i <= j) {
	                    E tmp = list[i];
	                    list[i] = list[j];
	                    list[j] = tmp;
	                    i++;
	                    j--;
	                }
	 
	            } while (i <= j);
	 
	           quickSort(list, first, j);
	           quickSort(list, i, last);
	        }
		return System.currentTimeMillis() - startTime;
	}
}
