

public class HeapTry <E extends Comparable<E>> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	
	public HeapTry(){
	}
	
	public HeapTry(E[] objects){
		for (int i = 0; i < objects.length; i++){
			add(objects[i]);
		}
	}
	public void add(E newObject) {
		list.add(newObject);
		int currentIndex = list.size() - 1;
		
		while (currentIndex > 0) {
			int parIndex = (currentIndex - 1) / 2;
			
			if (list.get(currentIndex).compareTo(list.get(parIndex)) > 0){
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parIndex));
				list.set(parIndex, temp);
			}
			else
				break;
			
			currentIndex = parIndex;
		}
	}
	public E remove() {
		if(list.size() == 0) return null;
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()){
			int lftChdIndex = 2 * currentIndex + 1;
			int rgtChdIndex = 2 * currentIndex + 2;
			
			if(lftChdIndex >= list.size()) break;
			
			int maxIndex = lftChdIndex;
			
			if(rgtChdIndex < list.size()){
				if(list.get(maxIndex).compareTo(list.get(rgtChdIndex)) < 0){
					maxIndex = rgtChdIndex;
				}
			}
			
			if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			}
			else
				break;
		}
		return removedObject;		
	}
	
	public int getSize(){
		return list.size();
	}
}
