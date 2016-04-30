
public interface IMaxPQ<Key extends Comparable<Key>> {
	void insert(Key v);
	Key delMax();
	boolean isEmpty();
	int size();
}
