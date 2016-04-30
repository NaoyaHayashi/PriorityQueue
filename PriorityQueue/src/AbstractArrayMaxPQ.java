
public abstract class AbstractArrayMaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key> {

	protected int   N; // size
	protected Key[] array;
	
	@SuppressWarnings("unchecked")
	public AbstractArrayMaxPQ() {
		N = 0;
		// If the capacity of the array is not specified, it becomes 100.
		array = (Key[]) new Comparable[100];
	}
	@SuppressWarnings("unchecked")
	public AbstractArrayMaxPQ(int capacity) {
		N = 0;
		array = (Key[]) new Comparable[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0; 
	}
	
	/*
	public String toString(){
		String str = "";
		if(N==0){
			return str; // return empty string
		}
		for(int i=0; i<N; i++){
			str = str + array[i];
		}
		return str;
	}*/
	
	
	// Unimplemented.
	public abstract void insert(Key v);
	public abstract Key delMax();


}
