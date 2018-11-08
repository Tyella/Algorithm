package AvlTree;
/**
 * Implements an AVL tree.
 * Note that all matching is based on the compareTo method.
 * @author Tyella
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>>{
	public static class AvlNode<AnyType>{
		AnyType element;
		AvlNode<AnyType> left;
		AvlNode<AnyType> right;
		int height;
		
		public AvlNode(AnyType element) {
			this(element,null,null);
		}
		public AvlNode(AnyType element,AvlNode<AnyType> left,AvlNode<AnyType> right) {
			this.element=element;
			this.left=left;
			this.right=right;
			height=0;
		}
	}
	
	private AvlNode<AnyType> root;
	private static final int ALLOWED_IMBALANCE=1;
	/**
	 * Construct the tree
	 */
	public AvlTree() {
		root=null;
	}
	/**
	 * Rotate binary tree node with left child.
	 * For Avl trees,this is a single rotation for case 1.(LL)
	 * Update heights,then return new root.
	 * @return
	 */
	//LL
	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k1.height=Math.max(height(k1.left), k2.height)+1;
		k2.height=Math.max(height(k2.left),height(k2.right))+1;
		return k1;
	}
	//RR
	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1){
		AvlNode<AnyType> k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k1.height=Math.max(height(k1.left), height(k1.right));
		k2.height=Math.max(k1.height, height(k2.right));
		return k2;
	}
	
	/**
	 * Double rotate binary tree node:first left child with its right child;
	 * Then node k3 with new left child.  (k1<k2<k3)
	 * For Avl trees,this is a double rotation for case 2.(LR)
	 * Update heights,then return new roots
	 */
	//LR
	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3){
		k3.left=rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	//RL
	private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k1){
		k1.right=rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
	/**
	 * Return the height of node t,or -1,if null
	 */
	private int height(AvlNode<AnyType> t) {
		return t==null?-1:t.height;
	}
	/**
	 * Assume t is either balanced or within one of being balanced.
	 */
	private AvlNode<AnyType> balance(AvlNode<AnyType> t){
		if(t==null)
			return t;
		if(height(t.left)-height(t.right)>ALLOWED_IMBALANCE)
			if(height(t.left.left)>=height(t.left.right))
				t=rotateWithLeftChild(t);
			else
				t=doubleWithLeftChild(t);
		else
			if(height(t.right)-height(t.left)>ALLOWED_IMBALANCE)
				if(height(t.right.right)>=height(t.right.left))
					t=rotateWithRightChild(t);
				else
					t=doubleWithRightChild(t);
		t.height=Math.max(height(t.left), height(t.right));
		return t;
	}
	
	/**
	 * Insert into the tree;duplicates are ignored
	 * @param t the item to insert
	 */
	public void insert(AnyType t) {
		root=insert(t,root);
	}
	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert
	 * @param t the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t){
		if(t==null)
			return new AvlNode<AnyType>(x,null,null);
		int compareResult=x.compareTo(t.element);
		if(compareResult<0)
			t.left=insert(x,t.left);
		else if(compareResult>0)
			t.right=insert(x,t.right);
		else
			;    //duplicate,do nothing
		return balance(t);
	}
	
	/**
	 * Remove from the tree.Nothing is done if x is not found.
	 * @param x the item to remove
	 */
	public void remove(AnyType x) {
		root=remove(x,root);
	}
	private AvlNode<AnyType> remove(AnyType x,AvlNode<AnyType> t){
		if(t==null)
			return t;      //item not found,do nothing        
		int compareResult=x.compareTo(t.element);
		if(compareResult<0)
			t.left=remove(x,t.left);
		else if(compareResult>0)
			t.right=remove(x,t.right);
		else if(t.left!=null && t.right!=null)
		{
			t.element=findMin(t.right).element;
			t.right=remove(t.element,t.right);
		}
		else 
			t=(t.left!=null)?t.left:t.right;
		return balance(t);
	}
	/**
	 * Find the smallest item in the tree.
	 * @return smallest item or null if empty
	 */
	public AnyType findMin() {
		if(isEmpty())
			throw new NullPointerException();
		return findMin(root).element;
	}
	private AvlNode<AnyType> findMin(AvlNode<AnyType> t){
		if(t==null)
			return null;
		while(t!=null)
			t=t.left;
		return t;
	}
	public AnyType findMax() {
		if(isEmpty())
			throw new NullPointerException();
		return findMax(root).element;
	}
	private AvlNode<AnyType> findMax(AvlNode<AnyType> t){
		if(t==null)
			return t;
		while(t!=null)
			t=t.right;
		return t;
	}
	public boolean contains(AnyType x) {
		return contains(x,root);
	}
	/**
	 * Internal method to find an item in an subtree.
	 */
	private boolean contains(AnyType x,AvlNode<AnyType> t) {
		while(t!=null) {
			int compareResult=x.compareTo(t.element);
			if(compareResult>0)
				t=t.right;
			else if(compareResult<0)
				t=t.left;
			else
				return true;                //match
		}
		return false;
	}
	public void checkbalance() {
		checkbalance(root);
	}
	private int checkbalance(AvlNode<AnyType> t) {
		if(t==null)
			return -1;
		if(t!=null) {
		int hl=checkbalance(t.left);
		int hr=checkbalance(t.right);
		if(Math.abs(height(t.left)-height(t.right))>1|| height(t.left)!=hl|| hr!=height(t.right))
			System.out.println("OOPS");
		}
		return height(t);
	}
	/**
	 * Test if the tree is logically empty
	 * @return true is empty,false otherwise
	 */
	public boolean isEmpty() {
		return root==null;
	}
	/*
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if(isEmpty())
			System.out.println("empty tree");
		printTree(root);
	}
	private void printTree(AvlNode<AnyType> x) {
		if(x!=null) {
			printTree(x.left);
			System.out.println(x.element);
			printTree(x.right);
		}
	}
}
