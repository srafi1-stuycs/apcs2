//Shakil Rafi
//APCS2 pd4
//HW17 -- Give and take
//2017-03-13

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add(String str) {
	if (_size == 0) {
	    _head = new LLNode(str, null);
	} else {
	    LLNode currentLLNode = _head;
	    while (currentLLNode.getNext() != null) {
		currentLLNode = currentLLNode.getNext();
	    }
	    currentLLNode.setNext(new LLNode(str, null));
	}
	_size += 1;
	return true;
    }

    public String get(int i) {
	LLNode currentLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentLLNode = currentLLNode.getNext();
	}
	return currentLLNode.getCargo();
    }
		      

    public String set(int i, String s) {
	LLNode currentLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentLLNode = currentLLNode.getNext();
	}
	String old = currentLLNode.getCargo();
	currentLLNode.setCargo(s);
	return old;
    }

    public void add(int index, String newVal) {
	if (index == 0) {
	    _head = new LLNode(newVal, _head);
	} else {
	    LLNode currentLLNode = _head;
	    for (int i = 1; i < index; i++) {
		currentLLNode = currentLLNode.getNext();
	    }
	    LLNode newNode = new LLNode(newVal, currentLLNode.getNext());
	    currentLLNode.setNext(newNode);
	}
    }

    public String remove(int index) {
	String ret = "";
	if (index == 0) {
	    ret = _head.getCargo();
	    _head = _head.getNext();
	} else {
	    LLNode currentLLNode = _head;
	    for (int i = 1; i < index; i++) {
		currentLLNode = currentLLNode.getNext();
	    }
	    ret = currentLLNode.getNext().getCargo();
	    currentLLNode.setNext(currentLLNode.getNext().getNext());
	}
	return ret;
    }
    
    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
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



