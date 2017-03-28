//Shakil Rafi
//APCS2 pd4
//HW26 -- The English Do Not Wait In Line
//2017-03-28

/*****************************************************
 * class LLQueue
 * uses a singly-linked nodes to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
	{ 
	    _front = null;
	    _end = null;
	}

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	if (isEmpty()) {
	    LLNode l = new LLNode(enQVal, null);
	    _front = l;
	    _end = l;
	} else {
	    _front = new LLNode<T>(enQVal, _front);
	}
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	T ret = _front.getValue();
	_front = _front.getNext();
	if (isEmpty())
	    _end = null;
	return ret;
    }//O(1)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(1)


    public boolean isEmpty() 
    {
	return _front == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String ret = "FRONT-->";
	LLNode current = _front;
	while (current != null) {
	    ret += current.getValue() + "-->";
	    current = current.getNext();
	}
	ret += "END";
	return ret;
    }//O(n)



    public static void main( String[] args ) {

	  Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );

	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );

    }//end main

}//end class LLQueue
