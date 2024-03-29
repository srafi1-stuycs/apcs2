//Shakil Rafi
//APCS2 pd4
//HW35 -- BSTs is the Perfect Place for Shade
//2017-05-04

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
	preOrderTrav(root);
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
	inOrderTrav(root);
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
	postOrderTrav(root);
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



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return search(root, target);
    }

    TreeNode search(TreeNode tn, int target) {
	if (tn == null)
	    return null;
	else if (target == tn.getValue())
	    return tn;
	else if (target < tn.getValue())
	    return search(tn.getLeft(), target);
	else
	    return search(tn.getRight(), target);
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
	return height(root);
    }

    public int height(TreeNode tn) {
	if (tn == null)
	    return 0;
	else
	    return Math.max(height(tn.getLeft()), height(tn.getRight())) + 1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(root);
    }

    public int numLeaves(TreeNode tn) {
	if (tn == null)
	    return 0;
	else if (tn.getLeft() == null && tn.getRight() == null)
	    return 1;
	else
	    return numLeaves(tn.getLeft()) + numLeaves(tn.getRight());
    }


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

	  //insert your new test calls here...
	  System.out.println();
	  System.out.println("Height: " + arbol.height());
	  System.out.println("Num Leaves: " + arbol.numLeaves());
	  System.out.println("Search for 6: " + arbol.search(6).getValue());
	  System.out.println("Search for 7: " + arbol.search(7));
    }

}//end class
