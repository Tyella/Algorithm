package Sort;

public class sort {
	/**
	 * simple insertion sort.
	 * @param a an array of Comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void insertionSort(AnyType[] a) {
		int j;
		for(int p=1;p<a.length;p++) 
		{
			AnyType temp=a[p];
			for(j=p;j>0 && temp.compareTo(a[j-1])<0;j--)
				a[j]=a[j-1];
			a[j]=temp;
		}
	}
	
	/**
	 * Shellsort,using Shell's increments.
	 * @param a an array of Comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void shellSort(AnyType[] a) {
		int j;
		for(int gap=a.length/2;gap>0;gap/=2)
			for(int p=gap;p<a.length;p++)
			{
				AnyType temp=a[p];
				for(j=p;j>=gap && temp.compareTo(a[j-gap])<0;j-=gap)
					a[j]=a[j-gap];
				a[j]=temp;	
			}
	}
	
	/**
	 * Internal method for heapsort.
	 * @param i the index of an item in the heap.
	 * @return the index of the left child.
	 */
	public static int leftChild(int i) {
		return 2*i+1;
	}
	
	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap.
	 * @param a an array of Comparable items.
	 * @param i the position from which to percolate down.
	 * @param n the logical size of the binary heap.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void percolateDown(AnyType[] a,int i,int n) {
		int child;
		AnyType tmp;
		for(tmp=a[i];leftChild(i)<n;i=child) {
			child=leftChild(i);
			if(child!=n-1 && a[child].compareTo(a[child+1])<0)
				child++;
			if(tmp.compareTo(a[child])<0)             //max heap
				a[i]=a[child];
			else
				break;
		}
		a[i]=tmp;
	}
	
	/**
	 * Standard heapsort.
	 * @param a an array of Comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void heapSort(AnyType[] a) {
		for(int i=a.length/2-1;i>0;i--) {
			percolateDown(a,i,a.length);
		}
		for(int i=a.length-1;i>0;i--) {
			swapReferences(a,0,i);            //deleteMax
			percolateDown(a,0,i);
		}
	}
	
	public static <AnyType> void swapReferences(AnyType[] a,int index1,int index2) {
		AnyType tmp=a[index1];
		a[index1]=a[index2];
		a[index2]=tmp;
	}
	
	/**
	 * Mergesort algorithm.
	 * @param a an array of Comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a) {
		AnyType[] tmpArray=(AnyType[])new Comparable[a.length];
		mergeSort(a,tmpArray,0,a.length-1);
	}
	
	/**
	 * Internal method that makes recursive calls.
	 * @param a an array of Comparable items.
	 * @param tmpArray an array to place the merge result.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a,AnyType[] tmpArray,int left,int right) {
		if(left<right) {
			int center=(left+right)/2;
			mergeSort(a,tmpArray,left,center-1);        //分治思想
			mergeSort(a,tmpArray,center,right);
			merge(a,tmpArray,left,center+1,right);
		}
	}
	
	/**
	 * Internal method that merges two sorted halves of a subarray.
	 * @param a an array of Comparable items.
	 * @param tmpArray an array to place the merged result.
	 * @param leftPos the left-most index of the subarray.
	 * @param rightPos the index of the start of the second half.
	 * @param rightEnd the most-right index of the subarray.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void merge(AnyType[] a,AnyType[] tmpArray,int leftPos,int rightPos,int rightEnd) {
		int leftEnd=rightPos-1;
		int tmpPos=leftPos;
		int numElements=rightEnd-leftPos+1;
		while(leftPos<=leftEnd && rightPos<=rightEnd)
		{
			if(a[leftPos].compareTo(a[rightPos])<=0)
				tmpArray[tmpPos++]=a[leftPos++];
			else
				tmpArray[tmpPos++]=a[rightPos++];
		}
		while(leftPos<=leftEnd)        //copy rest of first half
			tmpArray[tmpPos++]=a[leftPos++];
		while(rightPos<=rightEnd)
			tmpArray[tmpPos++]=a[rightEnd++];
		for(int i=0;i<numElements;i++,rightEnd--)
			a[rightEnd]=tmpArray[rightEnd];
	}
	
	/*
	 * Return median of left,right and center.
	 * Order these and hide the pivot.
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	AnyType median3(AnyType[] a,int left,int right) {
		int center=(left+right)/2;
		if(a[left].compareTo(a[right])>0)
			swapReferences(a,left,right);
		if(a[center].compareTo(a[right])>0)
			swapReferences(a,center,right);
		if(a[left].compareTo(a[center])>0)
			swapReferences(a,left,center);
		
		//Place pivot at position right-1
		swapReferences(a,center,right-1);
		return a[right-1];
	}
	
	public static final int CUTOFF=10;        //小数组用插入排序（长度小于10的数组），对于小数组，快排和插入排序用时差不多
	/**
	 * Internal quicksort method that makes recursive calls.
	 * @param a an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most inex of the subarray.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void quickSort(AnyType[] a,int left,int right) {
		if(left+CUTOFF<=right) {     //数组长度大于10，用快排（分治思想，分成更小的的单位，然后用插入排序）
			AnyType pivot=median3(a,left,right);
			
			 //begin pratitioning
			int i=left,j=right-1;
			for(;;) {
				while(a[++i].compareTo(pivot)<0) {}
				while(a[--j].compareTo(pivot)>0) {}
				if(i<j)
					swapReferences(a,i,j);
				else 
					break;
			}
			swapReferences(a,i,right-1);         //Restore pivot
			quickSort(a,left,i-1);               //sort small elements 
			quickSort(a,i+1,right);              //sort large elements
		}
		else
			insertionSort(a,left,right);         //Do an insertion sort on the subarray.
	}
	
	public static void quicksort1(int[] a,int left,int right) {
		if(left+CUTOFF<=right) {
			int pivot=median(a,left,right);
			int i=left,j=right-1;
			for(;;) {
				while(a[++i]<pivot) {};
				while(a[--j]>pivot) {};
				if(i<j)
					swapReference(a,i,j);
				else 
					break;
			}
			swapReference(a,i,right-1);
			quicksort1(a,left,i-1);
			quicksort1(a,i+1,right);
		}
		else
			insertionSort(a,left,right);
	}
	public static int median(int[] a,int left,int right) {
		int center=(left+right)/2;
		if(left>center)
			swapReference(a,left,center);
		if(left>right)
			swapReference(a,left,right);
		if(center>right)
			swapReference(a,center,right);
		
		swapReference(a,center,right-1);
		
		return a[right-1];
	}
	public static void swapReference(int[] a,int index1,int index2) {
		int tmp=a[index1];
		a[index1]=a[index2];
		a[index2]=tmp;
	}
	public static void insertionSort(int[] a,int left,int right) {
		for(int i=left+1;i<=right;i++) {
			int tmp=a[i];
			int j;
			for(j=i;j>left && a[j]<a[j-1];j--) {
					a[j]=a[j-1];
			}
			a[j]=tmp;
		}
	}
	/**
	 * Internal insertion sort routine for subarrays
	 * @param a an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void insertionSort(AnyType[] a,int left,int right) {
		for(int p=left+1;p<=right;p++) {
			AnyType tmp=a[p];
			int j;
			for(j=p;j>left && tmp.compareTo(a[j-1])<0;j--) 
				a[j]=a[j-1];
			a[j]=tmp;
		}
	}
}
