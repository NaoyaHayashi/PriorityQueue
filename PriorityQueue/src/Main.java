public class Main {
	public static void main(String[] args)
	{
		int NUM_ELEMENTS = 5;
		//IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(NUM_ELEMENTS);
		//IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>(NUM_ELEMENTS);
		MaxPQ<Integer> pq = new MaxPQ<Integer>(NUM_ELEMENTS+1);
		
		System.out.println("Insert random integers...");
		for(int i = 0; i < NUM_ELEMENTS; i++) {
			// draw a random number between 1 and 100
			int rand_num = (int) Math.ceil(Math.random()*100);
			pq.insert(rand_num);
			System.out.println("Insert " + rand_num);
		}
		
		System.out.println("");
		pq.printKeys();
		
		System.out.println("\nRemove numbers from largest to smallest...");
		for(int i=0; i<NUM_ELEMENTS; i++){
			System.out.println(pq.delMax() + " is removed");
		}
		
	}
	
	// Possible testing function
	public static void testMaxPQ(IMaxPQ<Integer> pq) {
		int numElts = 100;
		
		System.out.println("Inserting " + numElts + " random elements...");
		for(int i = 0; i < numElts; i++) {
			// draw a random number between 1 and 1000
			int rand_num = (int) Math.ceil(Math.random()*1000);
			pq.insert(rand_num);
		}
		
		System.out.println("Now removing items from priority queue...");
		
		int previous = pq.delMax();
		int count = 1;
		
		while(!pq.isEmpty()) {
			int current = pq.delMax();
			if (current > previous)
				System.out.println("Removed items in wrong order!!");
			previous = current;
			count++;
		}
		
		if(count != numElts)
			System.out.println("Somehow some elements disappeared: we did not remove as many as we inserted.");
	}
}