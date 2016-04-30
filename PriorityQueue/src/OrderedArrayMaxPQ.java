public class OrderedArrayMaxPQ<Key extends Comparable<Key>> extends AbstractArrayMaxPQ<Key> {

	public OrderedArrayMaxPQ(int capacity) {
		// Execute the parent class' constructor.
		super(capacity);
	}

	public void insert(Key v) {
		// TODO Auto-generated method stub
		if(N<=0){
			array[0] = v;
			N = 1;
			return;
		}
		
		// note: if the array is fully filled with numbers and v is largest, v won't be inserted due to size capacity of the array
		for(int i=0; (i<array.length && i<N); i++){
			int cmp = v.compareTo(array[i]);
			// v is greater
			if(cmp > 0){
				// if this i points to the last element of the array, append the key at the end of the array
				if(i+1 == N){
					array[N] = v;
					if(N < array.length){
						N++;
					}
					break;
				}
			}
			else{
				shift(i);
				array[i] = v;
				if(N < array.length){
					N++;
				}
				break;
			}
		}
		
	}
	
	
	private void shift(int index){
		
		for(int i=(array.length-1); i>index; i--){
			array[i] = array[i-1];
		}
		return;
	}

	public Key delMax() {
		// TODO Auto-generated method stub
		if(N<=0){
			N = 0;
			return null;
		}
		
		Key aKey = array[N-1];
		N--;
		return aKey;
	}
	
	
	// trying to make recursive insert but doesn't work
	/*
	private void implementInsert(Key aKey, int index){
		System.out.println("Index " + index);
		int cmp = aKey.compareTo(array[index]);
		
		// case 1: aKey is greater
		if(cmp > 0){
			// if aKey is the largest, programming flow must come here
			if((index+1) >= N){
				array[index] = aKey;
				N++;
				System.out.println("SDFC");
				return;
			}
			else{
				System.out.println("DDD");
				implementInsert(aKey, index+1);
			}
		}
		// case 2: two keys are equal or the key in the array is greater, so insert must be implemented here
		else{
			System.out.println("Shift");
			shift(index);
			array[index] = aKey; // inserting an element
			N++;
		}
		return;
	}*/

}