package datastructures.fibonacci;
import datastructures.IHeap;
import java.util.ArrayList;
/**
 * @author chm, remeeh
 * @param <A>
 * @param <K>
 */
public class SimpleFibonacci<A, K extends Comparable<K>> implements IHeap<A,K>{

	// Map used for decrease specific key and contains
	private ArrayList<Node> nodeMap;
	// Root node to access the heap
	private Heap heap;
	//arralyist to keep track of ranks
	private ArrayList<Node>A;
	//golden ratio
	private final double gratio=1.618033;

	public SimpleFibonacci(int n) {
		// Initializing map with ref's to where in the heap stuff is.
		// Index is 'ID' and Val i Ref to node in heap
		this.nodeMap = new ArrayList<Node>(n);
		//initialize arraylist with size logarithmic to n
		this.A= new ArrayList<Node>((int) (Math.log(n)/Math.log(gratio)));
		// Initializing the main Heap
		this.heap = new Heap();
	}

	// Inserts a new Entry into the Heap
	public void Insert(A info, K key){

	}

	// Returns minimum Key
	public K FindMin(){
		return this.heap.root.Key();
	}

	// Removes minimum Key, and returns it
	public K DeleteMin(){
		return null;
	}

	// Checks is Heap is empty

	public boolean IsEmpty(){
		return this.heap.root.equals(null);
	}

	// Checks if a given A(could be vertex) is in the Heap returns boolean
	public boolean Contains(A a){
		return false;
	}

	// Decreases the key of a given A 
	public void DecreaseKey(A a, K key){

	}

	//Internal Heap Class
	private class Heap {
		// A heap is considered empty if the root is null
		private Node root;
		public Node Root() { return this.root; }
	}

	//Internal Node class 
	private class Node {
		//key of the node
		private K key;
		//info (data related to the node)
		private A info;
		//rank and state
		private int rank;
		private boolean state;
		//pointers to siblings
		private Node next;
		private Node prev;
		//parent
		private Node parent;
		//pointer to first child
		private Node firstChild;

		// Setters
		public void Info(A Info) { this.info = Info; }
		public void Key(K Key) { this.key = Key; }
		public void Rank(int Rank) { this.rank = Rank; }
		public void State(boolean State) { this.state = State; }
		public void FirstChild(Node Child) { this.firstChild = Child; }
		public void Parent(Node Parent) { this.parent = Parent; }
		public void Prev(Node Prev) { this.prev = Prev; }
		public void Next(Node Next) { this.next = Next; }

		// Getters
		public K Key() { return this.key; }
		public Node FirstChild() { return this.firstChild; }
                public boolean State(){return this.state;}
                public Node Parent(){return this.parent;}
                public int Rank(){return this.rank;}
                public Node Prev(){return this.prev;}
                public Node Next(){return this.next;}

                        
		@Override
		public String toString()
		{
			return key.toString();
		}

	}//end of private class Node

	private Node makeItem(A info, K key) {
		Node x = new Node();
		x.Info(info);
		x.Key(key);
		x.Rank(0);
		x.State(false);
		x.FirstChild(null);
		return x;
	}

	private Node meld(Node g, Node h) {
		if(g.equals(null)) return h;
		if(h.equals(null)) return g;
		return link(g,h);
	}

	private Node link(Node x, Node y) {
		if((x.Key().compareTo(y.Key())) >= 0) {
			addChild(x, y);
			return y;
		} else {
			addChild(y, x);
			return x;
		}
	}

	private void addChild(Node x, Node y) {
		x.Parent(y);
		Node z = y.FirstChild();
		x.Prev(null);
		x.Next(z);
		if(!z.equals(null)) {
			z.Prev(x);
		}
		y.FirstChild(x);

	}

	private Node insert(Node x, Heap h) {
		return meld(x, h.Root());
	}

	private void Cut(Node x)
	{
		Node y =new Node(); 
		y =x.Parent();
		if(y.FirstChild().equals(x)){ y.FirstChild(x.Next());}
		if(x.Prev()!=null){x.Prev().Next(x.Next());}
		if(x.Next()!=null){x.Next().Prev(x.Prev());}
	}

	private void decreaseRank(Node y)
	{
		do{
			y=y.Parent();
			if(y.Rank()>0){ y.Rank(y.Rank()-1);}
			y.State(!y.State());
		}while(y.State()==false);
	}

	private Node decreaseKey(Node x,K k,Node h)
	{
		x.Key(k);
		if(x.equals(h)){return h;}

		h.State(false);
		decreaseRank(x);
		Cut(x);
		return link(x,h);
	}

	private double logOfBase(int base, int num) {
		return Math.log(num) / Math.log(base);
	}


}
