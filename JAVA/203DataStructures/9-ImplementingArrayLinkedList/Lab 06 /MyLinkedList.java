import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E>{
	private Node<E> head, tail;
	public MyLinkedList() {
		this.head = this.tail = null;
	}
	
	public MyLinkedList(E[] objects){
		super(objects);
	}
	@Override
	public void add(int index, E e) {
		if (index == 0) addFirst(e);
		else if (index >= size) addLast(e);
		else{
			Node<E> current = head;
			for (int i = 1; i < index; i++){
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean contains(E e) {
		if(indexOf(e) != -1) return true;
		else
		return false;
	}

	@Override
	public E get(int index) {
		Node<E> nextNode = head;
		int i = 1;
		while(i < index){
			nextNode = nextNode.next;
			i++;
		}
		return nextNode.element;
	}

	@Override
	public int indexOf(E e) {
		Node<E> newNode = head;
		int index = 0;
		while (newNode != null){
			if (e == null){
				if(newNode.element == null){
					return index;
				}
			}else if(e.equals(newNode.element)){
				return index;
			}
			newNode = newNode.next;
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		int index = 0;
		int found = -1;
		Node<E> current = head;
		while(index < size){
			if(current.next == e){
				found = index;
			}
			index++;
		}
		return found;
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size) return null;
		else if (index == 0) return removeFirst();
		else if (index == size - 1) return removeLast();
		else {
			Node<E> previous = head;

			for(int i = 1; i < index; i++){
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
}


	@Override
	public Object set(int index, E e) {
		Node<E> current = head;
		Node<E> old = current;
		Node<E> oldVal = old;
		oldVal.element = old.element;
		return oldVal;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(){
			private int counter = 1;
			@Override
			public boolean hasNext() {
				if(counter <= size){
					return true;
				}
				return false;
			}

			@Override
			public E next() {
				E object = get(counter);
				counter++;
				return object;
			}
			
		};
	}

	public static class Node<E>{
			E element;
			Node<E> next;
			
			public Node (E e){
				this.element = e;
			}
	}
	public void addFirst(E e){
		Node<E> newN = new Node<>(e);
		newN.next = head;
		head = newN;
		size++;
		
		if (tail == null)
			tail = head;
		
	}
	public void addLast(E e){
		Node<E> newN = new Node<>(e);
		
		if (tail == null){
			head = tail = newN;
		}
		else{
			tail.next = newN;
			tail = tail.next;
		}
		
		size++;
	}
	
	public E removeFirst(){
		if (size == 0) return null;
		else{
			Node<E> temp = head;
			size--;
			if(head == null) tail = null;
			return temp.element;
		}
		
	}
	public E removeLast(){
		if (size == 0) return null;
		else if (size == 1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
			
			for(int i = 0;i < size - 2;i++)
				current = current.next;
			
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	
}


