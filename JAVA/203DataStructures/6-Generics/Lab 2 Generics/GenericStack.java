import java.util.*;

public class GenericStack <E> extends ArrayList<E>{

	private ArrayList<E>list;
	
	 
	
	/** Construct a stack with the default initial capacity */
	
	public GenericStack() {
	
		this.list = new ArrayList<>();
	
	}
	
	
	/** Construct a stack with the specified initial capacity */
	
	public GenericStack(int initialCapacity) {

		this.list = new ArrayList<>(initialCapacity);
//		elements = (E[])new Object[initialCapacity];

	}

 

	/** Push a new element into the top of the stack */
	
	public void push(E e) {
	
//		if (this.getSize() >= this.size()) {
//			E[] temp = (E[])new Object[elements.length * 2];
//			System.arraycopy(elements, 0, temp, 0, elements.length);
//			elements = temp;
//	}
//		return elements[size++] = value;
		list.add(e);
	}

 

	/** Return and remove the top element from the stack */
	
	public E pop() {
//		return elements[--size];
		E e = list.get(getSize()-1);
		list.remove(getSize()-1);
		return e;
	}
	
	 
	
	/** Return the top element from the stack */
	
	public E peek() {
	
		return list.get(this.getSize() - 1);
	
	}
	
	 
	
	/** Exercise03_21 whether the stack is empty */
	
	public boolean isEmpty() {
	
		return list.isEmpty();
	
	}

 

/** Return the number of elements in the stack */

	public int getSize() {
	
		return list.size();
	
	}
	
	public static void main(String[] args){
	
		GenericStack<String> stack1 = new GenericStack<>();
		
		stack1.push("fun!");
		
		stack1.push("is");
		
		stack1.push("Java");

 

	while (!stack1.isEmpty()){
	
		System.out.print(stack1.pop() + " ");
	
	}

 

	System.out.println();

 

	GenericStack<Integer> stack2 = new GenericStack<>();
	
	stack2.push(4);
	
	stack2.push(3);
	
	stack2.push(2);
	
	stack2.push(1);

 

	while (!stack2.isEmpty()){
	
		System.out.print(stack2.pop() + " ");
	
	}
	
		System.out.println();

	}

}