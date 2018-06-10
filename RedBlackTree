// RedBlackTree
//
// CONSTRUCTION: with no parameters
//
// *************************PUBLIC OPERATIONS***************************
// void insert(x)			--> Insert x
// void delete(x)			--> Delete x
// boolean contains         --> Return true if x is found
// Comparable findMin()		--> Return smallest item
// Comparable findMax()		--> Return largest item
// boolean isEmpty()		--> Return true if empty; else false
// void makeEmpty()			--> Remove all items
// void printTree()			--> Print all items
// *************************ERRORS**************************************
// Throws Exception if error

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method
 * @author ywxk_hpt
 */
 
public class RedBlackTree<AnyType extends Comparable<? super AnyType>>{
	
	//color
	private static final int BLACK = 1;
	private static final int RED = 0;
	
	//nil node
	private RedBlackNode<AnyType> nil;
	//root node
	private RedBlackNode<AnyType> root;
	
	//Node class
	private static class RedBlackNode<AnyType>{
		
		AnyType 			  element;  //data
		RedBlackNode<AnyType> left;		//left child
		RedBlackNode<AnyType> right;	//right child
		RedBlackNode<AnyType> parent;	//parent child
		int					  color;	//color
		
		RedBlackNode(AnyType theElement){
			
			this(theElement,null,null,null);
			
		}
		
		RedBlackNode(AnyType theElement,RedBlackNode<AnyType> lt,RedBlackNode<AnyType> rt,RedBlackNode<AnyType> pt){
			
			element = theElement;
			left = lt;
			right = rt;
			parent = pt;
			color = RedBlackTree.BLACK;
			
		}
		
	}
	
	public RedBlackTree(){
		
		nil = new RedBlackNode<>(null);
		root = nil;
		
	}
	
	/**
	 * left rotate
	 * @param x root of rotate
	 */
	private void leftRotate(RedBlackNode<AnyType> x){
		
		RedBlackNode<AnyType> y = x.right;
		x.right = y.left;
		if(y != nil)
			y.left.parent = x;
		y.parent = x.parent;
		if(x.parent == nil)
			root = y;
		else if (x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
		
	}
	
	/**
	 * right rotate
	 * @param y root of rotate
	 */
	private void rightRotate(RedBlackNode<AnyType> y){
		
		RedBlackNode<AnyType> x = y.left;
		y.left = x.right;
		if(y != nil)
			x.right.parent = y;
		x.parent = y.parent;
		if(y.parent == nil)
			root = x;
		else if(y == y.parent.left)
			y.parent.left = x;
		else
			y.parent.right = x;
		x.right = y;
		y.parent = x;
		
	}
	
	/**
	 * insert function
	 * @param item the data to insert
	 */
	public void insert(AnyType item){
		
		RedBlackNode<AnyType> z = new RedBlackNode<>(item);
		RedBlackNode<AnyType> y = nil;
		RedBlackNode<AnyType> x = root;
		while( x != nil){
			
			y = x;
			if(z.element.compareTo(x.element) < 0)
				x = x.left;
			else
				x = x.right;
			
		}
		
		z.parent = y;
		if(y == nil) //insert the first element
			root = z;
		else if(z.element.compareTo(y.element) < 0) 
			y.left = z;  //set z as left child
		else
			y.right = z; //set z as right child
		
		z.left = nil;
		z.right = nil;
		z.color = RedBlackTree.RED; //z is red
		
		insertFixUp(z);
	}
	
	/**
	 * fix up after insert data
	 * @param z the data to insert
	 */
	private void insertFixUp(RedBlackNode<AnyType> z){
		
		while(z.parent.color == RedBlackTree.RED){ //red red 
			
			if(z.parent == z.parent.parent.left){
				
				RedBlackNode<AnyType> y = z.parent.parent.right;
				if(y.color == RedBlackTree.RED){         //case 1
					z.parent.color = RedBlackTree.BLACK; //case 1
					y.color = RedBlackTree.BLACK;		 //case 1
					z.parent.parent.color = RedBlackTree.RED; //case 1
					z = z.parent.parent; 
				}else{
					if(z == z.parent.right){
						z = z.parent;						//case 2
						leftRotate(z);						//case 2
					}
					z.parent.color = RedBlackTree.BLACK;	//case 3
					z.parent.parent.color = RedBlackTree.RED;//case 3
					rightRotate(z.parent.parent);			//case 3
				}
				
			}else{
				
				RedBlackNode<AnyType> y = z.parent.parent.left;
				if(y.color == RedBlackTree.RED){       //case 4
					z.parent.color = RedBlackTree.BLACK; //case 4
					y.color = RedBlackTree.BLACK;     //case 4
					z.parent.parent.color = RedBlackTree.RED; //case 4
					z =  z.parent.parent;
				}else{
					if(z == z.parent.left){
						z = z.parent;				//case 5
						rightRotate(z);				//case 5
					}
					z.parent.color = RedBlackTree.BLACK;   //case 6
					z.parent.parent.color = RedBlackTree.RED; //case 6
					leftRotate(z.parent.parent);
				}
				
			}
							
		}
		root.color = RedBlackTree.BLACK;  //the root is black
				
	}
	
	/**
	 * delete a data, if data is not in the tree throw exception
	 * @param item the data to remove
	 */
	public void delete(AnyType item) throws Exception{
		
		RedBlackNode<AnyType> z = findPosition(item);
		if(z == nil)
			throw new Exception("the element is not in the tree");
		RedBlackNode<AnyType> y = z;
		int y_original_color = y.color; //remember the color
		
		RedBlackNode<AnyType> x;
		if(z.left == nil){
			x = z.right;  //trace
			RBTransplant(z,z.right);
		}else if(z.right == nil){
			x = z.left;
			RBTransplant(z,z.left);
		}else{
			y = treeMinimum(z.right); //find the min from z.right
			y_original_color = y.color;
			x = y.right;
			if(y.parent == z)
				x.parent = y;
			else{
				RBTransplant(y,y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			RBTransplant(z,y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if(y_original_color == RedBlackTree.BLACK) //black break the tree
			RBDeleteFixUp(x);
		
	}
	
	
	/**
	 * transplant node 
	 * @param u be replaced
	 * @param v to replace
	 */
	private void RBTransplant(RedBlackNode<AnyType> u,RedBlackNode<AnyType> v){
		
		if(u.parent == nil)
			root = v;
		else if(u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		v.parent = u.parent;
		
	}
	
	/**
	 * find the min
	 * @param x the node
	 * @return the min node
	 */
	 
	private RedBlackNode<AnyType> treeMinimum(RedBlackNode<AnyType> x){
		
		while(x.left != nil)
			x = x.left;
		return x;
	}
	
	/**
	 * find the max
	 * @param x the node
	 * @return the max node
	 */
	private RedBlackNode<AnyType> treeMaxmum(RedBlackNode<AnyType> x){
		
		while(x.right != nil)
			x = x.right;
		return x;
		
	}
	
	/**
	 * fix up after delete
	 * @param x 
	 */
	private void RBDeleteFixUp(RedBlackNode<AnyType> x){
		
		while(x != root && x.color == RedBlackTree.BLACK){
			
			if(x == x.parent.left){ //x is left child
				RedBlackNode<AnyType> w = x.parent.right;
				if(w.color == RedBlackTree.RED){
					w.color = RedBlackTree.BLACK;			//case 1
					x.parent.color = RedBlackTree.RED;		//case 1
					leftRotate(x.parent);					//case 1
					w = x.parent.right;						//case 1
				}
				if(w.left.color == RedBlackTree.BLACK && w.right.color == RedBlackTree.BLACK){
					w.color = RedBlackTree.RED;				//case 2
					x = x.parent;							//case 2
				}else{
					if(w.right.color == RedBlackTree.BLACK){
						w.left.color = RedBlackTree.BLACK;	//case 3
						w.color = RedBlackTree.RED;			//case 3
						rightRotate(w);						//case 3
						w = x.parent.right;					//case 3
					}
					w.color = x.parent.color;				//case 4
					x.parent.color = RedBlackTree.BLACK;	//case 4
					w.right.color = RedBlackTree.BLACK;		//case 4
					leftRotate(x.parent);					//case 4
					x = root;
				}								
			}else{						//x is right child
				RedBlackNode<AnyType> w = x.parent.left;
				if(w.color == RedBlackTree.RED){
					w.color = RedBlackTree.BLACK;			//case 5
					x.parent.color = RedBlackTree.RED;		//case 5
					rightRotate(x.parent);					//case 5
					w = x.parent.left;						//case 5
				}
				if(w.right.color == RedBlackTree.BLACK && w.left.color == RedBlackTree.BLACK){
					w.color = RedBlackTree.RED;				//case 6
					x = x.parent;							//case 6
				}else{
					if(w.left.color == RedBlackTree.BLACK){
						w.right.color = RedBlackTree.BLACK;	//case 7
						w.color = RedBlackTree.RED;			//case 7
						leftRotate(w);						//case 7
						w = x.parent.left;					//case 7
					}
					w.color = x.parent.color;				//case 8
					x.parent.color = RedBlackTree.BLACK;	//case 8
					w.left.color = RedBlackTree.BLACK;		//case 8
					rightRotate(x.parent);					//case 8
					x = root;					
				}
			}
			
		}
		
		x.color = RedBlackTree.BLACK; //set x color to black
	}
	
	
	/**
	 * find the smallest item of the tree
	 * @return the smallest element or throw Exception if empty
	 */
	public AnyType findMin() throws Exception{
		
		if(isEmpty())
			throw new Exception("tree is empty");
		
		RedBlackNode<AnyType> minNode = treeMinimum(root);
		return minNode.element;
	}
	
	/**
	 * find the largest item of the tree
	 * @return the largest element or throw Exception if empty
	 */
	public AnyType findMax() throws Exception{
		
		if(isEmpty())
			throw new Exception("tree is empty");
		
		RedBlackNode<AnyType> maxNode = treeMaxmum(root);
		return maxNode.element;
		
	}
	
	/**
	 * test if the tree is empty
	 * @return true if empty,false otherwise
	 */
	public boolean isEmpty(){
		
		return root == nil;
		
	}
	
	/**
	 * make the tree empty
	 */
	public void makeEmpty(){
		
		root = nil;
		
	}
	
	/**
	 * find an item in the tree
	 * @param x the item to search for
	 * @return true if x is found otherwise false
	 */
	public boolean contains(AnyType x){
		
		RedBlackNode<AnyType> node = findPosition(x);
		
		if(node != nil)
			return true;
		else
			return false;
		
	}
	
	/**
	 * find node x 
	 * @param x the data
	 * @return the node
	 */
	private RedBlackNode<AnyType> findPosition(AnyType x){
		
		RedBlackNode<AnyType> current = root;
		
		while(current != nil){
			
			if(x.compareTo(current.element) < 0)
				current = current.left;
			else if(x.compareTo(current.element) > 0)
				current = current.right;
			else
				return current;
			
		}
		
		return current;
				
	}
	/**
	 * print the tree
	 */
	public void printTree(){
		
		if(isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
		
	}
	
	/**
	 * internal method to print a subtree in sorted order.
	 * @param t the node that roots the subtree
	 */
	private void printTree(RedBlackNode<AnyType> t){
		
		if( t != nil){
			
			printTree(t.left);
			System.out.print(t.element + "	");
			printTree(t.right);
			
		}
		
	}
}
