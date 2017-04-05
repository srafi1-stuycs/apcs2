public class LLDeque<T> implements Deque<T> {

    //instance variables
    private int _size;
    private DLLNode<T> _front, _end;

    //constructor
    public LLDeque() {
	_size = 0;
	_front = null;
	_end = null;
    }

    //returns true if the deque is empty
    public boolean isEmpty() {
	return _size == 0;
    }

    //returns the size
    public int size() {
	return _size;
    }

    //adds a new DLLNode to the front of the Deque
    public void addFront(T obj) {
	//if the queue is empty, set the DLLNode as the front and back
	if (isEmpty()) {
	    DLLNode<T> l = new DLLNode<T>(obj, null, null);
	    _front = l;
	    _end = l;
	}
	//otherwise, set _front as the DLLNode, and point it to the old _front
	else {
	    _front = new DLLNode<T>(obj, null, _front);
	}
	_size++;
    }

    //removes an DLLNode from the front of the Deque
    //returns the value in that DLLNode
    public T removeFront() {
	//a temp set to return later
	T ret = _front.getValue();

	//sets the new _front as the second in line
	_front = _front.getNext();
	_size--;

	//if the deque only has one DLLNode to begin with, the deque must now be empty 
	if (isEmpty())
	    _end = null;
	//otherwise, if the deque ends up not empty, have _front point ahead to null
	else
	    _front.setPrev(null);
	return ret;
    }

    //returns the value in the DLLNode in the front of the Deque
    public T peekFront() {
	return _front.getValue();
    }

    //addes a new DLLNode to the back of the Deque
    public void addLast(T obj) {
	//if the deque is empty, set the DLLNode as _front and _end
	if (isEmpty()) {
	    DLLNode<T> l = new DLLNode<T>(obj, null, null);
	    _front = l;
	    _end = l;
	}
	//if deque isn't empty
	else {
	    //have _end point to the new DLLNode
	    _end.setNext(new DLLNode<T>(obj, _end, null));
	    //set _end to that DLLNode
	    _end = _end.getNext();
	}
	_size++;
    }

    //remove the DLLNode from the end of the Deque
    //returns the value of that DLLNode
    public T removeLast() {
	//temp storage for later return
	T ret = _end.getValue();
	//set _end to the next to last, since the last will be removed
	_end = _end.getPrev();
	_size--;
	//if deque originally has only one DLLNode, this makes sure both _front and _end are null
	if (isEmpty())
	    _front = null;
	//otherwise, set _end pointing to null instead of the removed DLLNode
	else
	    _end.setNext(null);
	return ret;
    }

    //returns the value of the last DLLNode in the Deque
    public T peekLast() {
	return _end.getValue();
    }

    //prints the Deque with the front on the left and end on the right
    public String toString() {
	String ret = "FRONT-->";
	DLLNode<T> curr = _front;
	while (curr != null) {
	    ret += curr.getValue() + "-->";
	    curr = curr.getNext();
	}
	ret += "END";
	return ret;
    }

    public static void main(String args[]) {
	LLDeque<String> deque = new LLDeque<String>();
	System.out.println("Starts as: " + deque);
	deque.addFront("bip");
	deque.addLast("bop");
	deque.addFront("bam");
	System.out.println("Now it's: " + deque);
	System.out.println(deque.removeLast());
	System.out.println("Removed one: " + deque);
	System.out.println(deque.removeFront());
	System.out.println("Removed one: " + deque);
    }
    
}
