package BinaryHeap;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
	private int currentsize;
	private AnyType[] array;
	private static final int DEFAULT_CAPACITY=10;
	
	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}
	public BinaryHeap(int capacity) {
		currentsize=0;
		array=(AnyType[]) new Comparable[capacity+1];
	}
	
	/**
	 * Construct the binary heap given an array of item.
	 */
	public BinaryHeap(AnyType[] items) {
		currentsize=items.length;
		array=(AnyType[]) new Comparable[(currentsize+2)*11/10];
		int i=1;
		for(AnyType item:items)
			array[i++]=item;
		buildHeap();
	}
	/**
	 * Insert into the priority queue,maintaining heap order.
	 * duplicates are allowed.
	 * @param x the item to insert
	 */
	public void insert(AnyType x) {
		if(currentsize==array.length-1)
			enLargeArray(array.length*2+1);
		//percolate up
		int hole=++currentsize;
		for(array[0]=x;x.compareTo(array[hole/2])<0;hole/=2)
			array[hole]=array[hole/2];
		array[hole]=x;
			
	}
	public AnyType findMin() {
		if(isEmpty())
			throw new NullPointerException();
		return array[1];
	}
	/**
	 * Remove the smallest item from the priority queue.
	 * @return the smallest item,or throw exception is empty.
	 */
	public AnyType deleteMin() {
		if(isEmpty())
			throw new NullPointerException();
		AnyType minItem=findMin();
		array[1]=array[currentsize--];
		percolateDown(1);
		return minItem;
	}
	public boolean isEmpty() {
		return currentsize==0;
	}
	public void makeEmpty() {
		currentsize=0;
	}
	
	/**
	 * Internal method to percolate down in the heap.
	 * @param hole the index at which the percolate begins.
	 */
	public void percolateDown(int hole) {
		int child;
		AnyType temp=array[hole];
		for(;hole*2<=currentsize;hole=child)
		{
			child=hole*2;
			if(child!=currentsize && array[child].compareTo(array[child+1])>0)     //找出左右孩子中的最小值
				child++;
			if(array[child].compareTo(temp)<0)
				array[hole]=array[child];
			else
				break;
		}
		array[hole]=temp;
	}
	/**
	 * Establish heap order property from an arbitrary arrangement of items.
	 * Runs in linear time.  //O(n)
	 */
	public void buildHeap() {
		for(int i=currentsize/2;i>0;i--)
			percolateDown(i);
	}
	public void enLargeArray(int newSize) {
		AnyType[] old=array;
		array=(AnyType[])new Comparable[newSize];
		for(int i=0;i<old.length;i++)
			array[i]=old[i];
	}
	public static void main(String[] args) {
		int numItems=10000;
		BinaryHeap<Integer> h=new BinaryHeap<>();
		int i=37;
		for(i=37;i!=0;i=(i+37)%numItems)
			h.insert(i);
		for(i=1;i<numItems;i++)
			if(h.deleteMin()!=i)
				System.out.println("Oops"+i);
	}
}
