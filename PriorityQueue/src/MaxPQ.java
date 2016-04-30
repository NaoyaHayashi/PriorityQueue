
// Implementation of the priority queue using a binary heap

public class MaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key> {
	
	private int size;
	private Key[] heapTree;
	
	@SuppressWarnings("unchecked")
	public MaxPQ(){
		size = 0;
		// If the capacity of the array is not specified, it becomes 100.
		heapTree = (Key[]) new Comparable[100];
	}
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity){
		size = 0;
		heapTree = (Key[]) new Comparable[capacity];
	}
	
	
	public void insert(Key v) {
		// TODO Auto-generated method stub
		size++;
		heapTree[size] = v;
		swim(size);
	}

	public Key delMax() {
		// TODO Auto-generated method stub
		final int TOP_NODE_POSITION = 1;
		Key delValue = heapTree[TOP_NODE_POSITION];
		heapTree[TOP_NODE_POSITION] = heapTree[size];
		size--;
		sink(TOP_NODE_POSITION);
		return delValue;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private void swim(int targetIndex){
		// targetIndex won't be 0 in this function, but it is just in case to make the function more stable.
		// Case 1: if the inserted value is largest of all the nodes, programming flow should come here.
		if(targetIndex == 0 || targetIndex == 1){
			return;
		}
		
		int comparison = heapTree[targetIndex].compareTo(heapTree[targetIndex/2]);
		// Case 2: the inserted position is right (i.e.: the child node's value is smaller than the parent node's
		if(comparison < 0){
			// do nothing
		}
		// Case 3: the child node's value is bigger than the parent node's --> needs swap
		else{
			swap(targetIndex, targetIndex/2);
			swim(targetIndex/2);
		}
	}
	
	private void sink(int targetIndex){
		// Base case
		if(size < targetIndex*2){
			return;
		}
		
		int comparison1;
		if(size == targetIndex*2){
			comparison1 = 1;
		}
		else{
			comparison1 = heapTree[targetIndex*2].compareTo(heapTree[targetIndex*2+1]);
		}
		int largerChildIndex;
		
		// calling object is larger or equal to argument
		if(comparison1 >= 0){
			largerChildIndex = targetIndex * 2;
		}
		// argument is larger
		else{
			largerChildIndex = targetIndex * 2 + 1;
		}
		
		int comparison2 = heapTree[targetIndex].compareTo(heapTree[largerChildIndex]);
		// parent is larger or equal to the (larger) child
		if(comparison2 >= 0){
			// do nothing
			return;
		}
		// (larger)child is larger
		else{
			swap(targetIndex, largerChildIndex);
			sink(largerChildIndex);
		}
	}
	
	private void swap(int parentIndex, int childIndex){
		Key temp = heapTree[parentIndex];
		heapTree[parentIndex] = heapTree[childIndex];
		heapTree[childIndex] = temp;
	}
	
	public void printKeys(){
		for(int i=1; i<=size; i++){
			System.out.print(heapTree[i] + " ");
		}
		System.out.println("");
	}

}
