/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
	return _heap.toString();
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    { 
	return _heap.get(0);
    } //O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    { 
	_heap.add(addVal); //starts off at end
	int level = 1;
	while (Math.pow(2, level) - 1 < _heap.size()) {
	    level++; //find level of new element
	}
	int myIndex = _heap.size() - 1; //current index of new element
	int subIndex = myIndex - (int) Math.pow(2, level - 1) - 1; //index of element within level
	int parentIndex = (int) Math.pow(2, level - 2) + (subIndex - 1)/2;
	while (myIndex > 0 && parentIndex >= 0 && _heap.get(myIndex) < _heap.get(parentIndex)) {
	    swap(myIndex, parentIndex);
	    myIndex = parentIndex; //update new element's index
	    level--;
	    subIndex = myIndex - (int) Math.pow(2, level - 1) - 1;
	    parentIndex = (int) Math.pow(2, level - 2) + (subIndex - 1)/2;
	}
    } //O(n)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
	if (_heap.size() == 1)
	    return _heap.remove(0);
	else if (_heap.size() == 0)
	    return null;
	int ret = _heap.get(0);
	_heap.set(0, _heap.remove(_heap.size() - 1));
	int index = 0;
	while (minChildPos(index) != -1) {
	    int newIndex = minChildPos(index);
	    if (_heap.get(index) < _heap.get(newIndex))
		break;
	    swap(index, newIndex);
	    index = newIndex;
	}
	return ret;
    }//O(n)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    public int minChildPos( int pos ) 
    {
	if (pos < 0 || pos >= _heap.size())
	    return -1;
	int level = 1;
	while (Math.pow(2, level) - 1 < pos) {
	    level++; //find level of current element
	}
	int subIndex = pos - (int) (Math.pow(2, level - 1) - 1);
	int childIndex1 = (int) (Math.pow(2, level) - 1) + subIndex*2;
	int childIndex2 = childIndex1 + 1;
	if (childIndex1 >= _heap.size() || childIndex1 < 0)
	    return -1;
	else if (childIndex2 >= _heap.size())
	    return childIndex1;
	else if (_heap.get(childIndex1) < _heap.get(childIndex2))
	    return childIndex1;
	else
	    return childIndex2;
    }//O(n)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {


	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);

    }//end main()

}//end class ALHeap
