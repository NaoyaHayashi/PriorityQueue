
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> extends AbstractArrayMaxPQ<Key> {

	public UnorderedArrayMaxPQ(int capacity) {
		// Execute the parent class' constructor.
		super(capacity);
	}

	public void insert(Key v) {
		// TODO Auto-generated method stub
		array[N] = v;
		N++;
	}

	public Key delMax() {
		// TODO Auto-generated method stub
		if(N==0){
			return null;
		}
		
		Key max = array[0];
		
		
		int maxIndex = 0;
		for(int i=1; i<N; i++){
			int cmp = max.compareTo(array[i]);
			if(cmp < 0 || cmp == 0){
				max = array[i];
				maxIndex = i;
			}
		}
		Key temp = array[maxIndex];
		array[maxIndex] = array[N-1];
		N--;
		
		return temp;
	}

}
