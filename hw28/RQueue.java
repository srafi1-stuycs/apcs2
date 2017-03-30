//Shakil Rafi
//APCS2 pd4
//HW28 --
//2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _size = 0;
	    _front = null;
	    _end = null;
	}


    
    public void enqueue( T enQVal ) 
    {
	if (isEmpty()) {
	    LLNode l = new LLNode(enQVal, null);
	    _front = l;
	    _end = l;
	} else {
	    _end.setNext(new LLNode(enQVal, null));
	    _end = _end.getNext();
	}
	_size++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	T ret = _front.getValue();
	_front = _front.getNext();
	if (isEmpty())
	    _end = null;
	_size--;
	sample();
	return ret;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * Choose a random node by traversing a random numberof nodes
     * Swap this node with the _front node
     * This effectively gets a random node with each dequeue
     * 
     ******************************************/
    public void sample () 
    {
	//System.out.println(this);
	if (_size < 2)
	    return;
	LLNode temp = _front;
	int lim = (int)(Math.random()*_size);
	for (int i = 0; i < lim - 1; i++) {
	    temp = temp.getNext();
	}
	LLNode newFront = temp.getNext();
	temp.setNext(temp.getNext().getNext());
	newFront.setNext(_front);
	_front = newFront;
	//System.out.println(this + "\n");
    }

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

    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...
	  System.out.println(PirateQueue.peekFront());
	  
	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing from empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
    }//end main

}//end class RQueue
