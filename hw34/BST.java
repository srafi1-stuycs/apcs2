//Shakil Rafi
//APCS2 pd4
//HW34 -- Algorithm as data structure
//2017-05-03

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    private TreeNode root;
    
    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	if (root == null) {
	    root = new TreeNode(newVal);
	} else {
	    insert(root, newVal);
	}
    }

    public void insert( TreeNode current, int newVal) {
	if (newVal < current.getValue()) {
	    if (current.getLeft() == null)
		current.setLeft(new TreeNode(newVal));
	    else
		insert(current.getLeft(), newVal);
	} else {
	    if (current.getRight() == null)
		current.setRight(new TreeNode(newVal));
	    else
		insert(current.getRight(), newVal);
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	if (root != null) {
	    System.out.print(root.getValue() + " ");
	    preOrderTrav(root.getLeft());
	    preOrderTrav(root.getRight());
	}
	System.out.println();
    }

    public void preOrderTrav(TreeNode current) {
	if (current != null) {
	    System.out.print(current.getValue() + " ");
	    preOrderTrav(current.getLeft());
	    preOrderTrav(current.getRight());
	}
    }

    public void inOrderTrav() 
    {
	if (root != null) {
	    inOrderTrav(root.getLeft());
	    System.out.print(root.getValue() + " ");
	    inOrderTrav(root.getRight());
	}
	System.out.println();
    }

    public void inOrderTrav(TreeNode current) {
	if (current != null) {
	    inOrderTrav(current.getLeft());
	    System.out.print(current.getValue() + " ");
	    inOrderTrav(current.getRight());
	}
    }

    public void postOrderTrav() 
    {
	if (root != null) {
	    postOrderTrav(root.getLeft());
	    postOrderTrav(root.getRight());
	    System.out.print(root.getValue() + " ");
	}
	System.out.println();
    }

    public void postOrderTrav(TreeNode current) {
	if (current != null) {
	    postOrderTrav(current.getLeft());
	    postOrderTrav(current.getRight());
	    System.out.print(current.getValue() + " ");
	}
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  //expected tree:
	  //         4
	  //        / \
	  //       2   5
	  //      / \   \
	  //     1   3   6

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();
	  //expected: 4 2 1 3 5 6
	  
	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	  //expected: 1 2 3 4 5 6
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	
	  //expected: 1 3 2 6 5 4
    }

}//end class
