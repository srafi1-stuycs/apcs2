//Shakil Rafi
//APCS2 pd4
//HW19 -- Generically Speaking...
//2017-03-16

public class LList<T> implements List<T>
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add(T str) {
	if (_size == 0) {
	    _head = new DLLNode<T>(str, null, null);
	} else {
	    DLLNode<T> currentDLLNode = _head;
	    while (currentDLLNode.getNext() != null) {
		currentDLLNode = currentDLLNode.getNext();
	    }
	    currentDLLNode.setNext(new DLLNode<T>(str, currentDLLNode, null));
	}
	_size += 1;
	return true;
    }

    public T get(int i) {
	DLLNode<T> currentDLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentDLLNode = currentDLLNode.getNext();
	}
	return currentDLLNode.getCargo();
    }
		      

    public T set(int i, T s) {
	DLLNode<T> currentDLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentDLLNode = currentDLLNode.getNext();
	}
	T old = currentDLLNode.getCargo();
	currentDLLNode.setCargo(s);
	return old;
    }

    public void add(int index, T newVal) {
	if (index == 0) {
	    _head = new DLLNode<T>(newVal, null, _head);
	} else {
	    DLLNode<T> currentDLLNode = _head;
	    for (int i = 1; i < index; i++) {
		currentDLLNode = currentDLLNode.getNext();
	    }
	    DLLNode<T> newNode = new DLLNode(newVal, currentDLLNode, currentDLLNode.getNext());
	    currentDLLNode.setNext(newNode);
	}
    }

    public T remove(int index) {
	T ret;
	if (index == 0) {
	    ret = _head.getCargo();
	    _head = _head.getNext();
	} else {
	    DLLNode<T> currentDLLNode = _head;
	    for (int i = 1; i < index; i++) {
		currentDLLNode = currentDLLNode.getNext();
	    }
	    ret = currentDLLNode.getNext().getCargo();
	    currentDLLNode.setNext(currentDLLNode.getNext().getNext());
	}
	return ret;
    }
    
    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	LList james = new LList();
	System.out.println(james);
	james.add("obi-wan");
	System.out.println(james);
	james.add(0, "anakin");
	System.out.println(james);
	james.add(1, "luke");
	System.out.println(james);
	james.remove(2);
	System.out.println(james);
    }

}//end class LList



