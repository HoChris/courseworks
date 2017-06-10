package lab4Algo;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
//use hashmap maybe or treemap
//use collection max for max count
//look at map api
public class effiencentAlgo {
	private static List<Integer> numbers;
	public static void main(String[] args) {
		myScanner();
		numCounter();
	}//end main

	public static void myScanner(){
		Scanner inUserNum = new Scanner(System.in);
		System.out.println("enter numbers then end with 0:");
		numbers = new ArrayList<Integer>();
		int tNum = 0;
		
		try {
			while(inUserNum.hasNext()){
				tNum = inUserNum.nextInt();
				if(tNum > 0 && tNum != 0){
					numbers.add(tNum);
//				System.out.println(tNum + " number added");
				}
				else
					break;
			}
			inUserNum.close();
		} catch (Exception e) {
			System.out.println("only valid integers please.\n");
			myScanner();
		}
//		System.out.println(numbers.toString());
	}
	
	public static void numCounter(){
		TreeMap <Integer, Integer> nMap = new TreeMap<>();
		
		for(int x : numbers){
			int daKey = x;
			
			if(nMap.get(daKey) == null){
				nMap.put(daKey, 1);
			}
			else{
				int daValue = nMap.get(daKey).intValue();
				daValue++;
				nMap.put(daKey,daValue);
			}
			
		}
		int maxNumber = Collections.max(nMap.values());
//		returns max number in the map values
//		System.out.println(maxNumber);
		
		for(Entry<Integer, Integer> search : nMap.entrySet()){
//		returns set view of the mappings contained in map	
			if(search.getValue() == maxNumber){
				System.out.printf( "the number %d"
						+ " occurs %d times.\n", search.getKey(), maxNumber);
			}
		}
		
	}
	
}
