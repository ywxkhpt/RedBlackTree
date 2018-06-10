public class TestRBTree{
	
	public static void main(String[] args) throws Exception{
		
		int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
		RedBlackTree<Integer> rbtree = new RedBlackTree();
		
		for(int element:a){
			
			rbtree.insert(element);
			
		}
		System.out.print("the smallest element: ");
		System.out.println(rbtree.findMin());
		System.out.print("the largest element: ");
		System.out.println(rbtree.findMax());
		System.out.println("120 in the tree: " + rbtree.contains(120));
		System.out.println("90 in the tree: " + rbtree.contains(90));
		System.out.println("-10 in the tree: " + rbtree.contains(-10));
		System.out.print("the element in the tree: ");
		rbtree.printTree();
		System.out.println();
		rbtree.delete(60);
		rbtree.delete(10);
		rbtree.delete(90);
		System.out.print("the element in the tree: ");
		rbtree.printTree();
		System.out.println();
		System.out.println("the tree is empty: " + rbtree.isEmpty());
		System.out.println("clear the tree");
		rbtree.makeEmpty();
		System.out.println("the tree is empty: " + rbtree.isEmpty());
		rbtree.delete(100);  //delete the element is not in the tree
		
		
		/**
		RedBlackTree<Integer> t = new RedBlackTree<>( );
        final int NUMS = 400000;
        final int GAP  =  35461;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        if( t.findMin( ) != 1 || t.findMax( ) != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 1; i < NUMS; i++ )
             if( !t.contains( i ) )
                 System.out.println( "Find error!" );
		
		t.printTree();
		*/
	}
	
}
