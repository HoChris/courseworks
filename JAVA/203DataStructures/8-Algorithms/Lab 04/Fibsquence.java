package lab4Algo;

import java.util.TreeMap;

public class Fibsquence {
static long startTime = 0;
static long endTime = 0;
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num4 = 40;	
		
		System.out.println(daFibSeq(num1));
		System.out.println(daFibSeq(num2));
		System.out.println(daFibSeq(num4));
		
		System.out.println(dynamicFib(num1));
		System.out.println(dynamicFib(num2));
		System.out.println(dynamicFib(num4));

	}
	
	public static long daFibSeq(int number){
		startTime = System.currentTimeMillis();
		if (number == 0){	
			return System.currentTimeMillis() - startTime;
		}
		else if (number == 1){
			return 1;
		}
		else{
			return (daFibSeq(number - 1) + daFibSeq(number - 2));
		}
		
	}		
	
	public static long dynamicFib(int number){
		startTime = System.currentTimeMillis();
		TreeMap<Integer, Integer> daMap = new TreeMap<>();
		
		daMap.put(0, 0);
		daMap.put(1, 1);
		
		if(!daMap.containsKey(number)){
			daMap.put(number, (int)dynamicFib(number - 1) + (int)dynamicFib(number - 2));
			return daMap.get(number);
		}
		else{
			return System.currentTimeMillis() - startTime;
		}

	}
}
