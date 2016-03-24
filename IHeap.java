package datastructures;

public interface IHeap<A, K extends Comparable<K>> {
	// A is the information (e.g. could be vertex id)
	// K is the comparable key (e.g. distanceTo vertex A from s)

	// Inserts a new Entry into the Heap
	public void Insert(A info, K key);

	// Returns minimum Key
	public K FindMin();

	// Removes minimum Key, and returns it 
	public K DeleteMin();

	// Checks is Heap is empty
	public boolean IsEmpty();

	// Checks if a given A(could be vertex) is in the Heap returns boolean
	public boolean Contains(A a);

	// Decreases the key of a given A 
	public void DecreaseKey(A a, K key);
}
