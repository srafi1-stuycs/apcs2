//Shakil Rafi
//APCS2 pd4
//HW18 -- On the DLL
//2017-03-15

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode _head;
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
	    _head = new DLLNode(str, null, null);
	} else {
	    DLLNode currentDLLNode = _head;
	    while (currentDLLNode.getNext() != null) {
		currentDLLNode = currentDLLNode.getNext();
	    }
	    currentDLLNode.setNext(new DLLNode(str, currentDLLNode, null));
	}
	_size += 1;
	return true;
    }

    public String get(int i) {
	DLLNode currentDLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentDLLNode = currentDLLNode.getNext();
	}
	return currentDLLNode.getCargo();
    }
		      

    public String set(int i, String s) {
	DLLNode currentDLLNode = _head;
	for (int j = 0; j < i; j++) {
	    currentDLLNode = currentDLLNode.getNext();
	}
	String old = currentDLLNode.getCargo();
	currentDLLNode.setCargo(s);
	return old;
    }

    public void add(int index, String newVal) {
	if (index == 0) {
	    _head = new DLLNode(newVal, null, _head);
	} else {
	    DLLNode currentDLLNode = _head;
	    for (int i = 1; i < index; i++) {
		currentDLLNode = currentDLLNode.getNext();
	    }
	    DLLNode newNode = new DLLNode(newVal, currentDLLNode, currentDLLNode.getNext());
	    currentDLLNode.setNext(newNode);
	}
    }

    public String remove(int index) {
	String ret = "";
	if (index == 0) {
	    ret = _head.getCargo();
	    _head = _head.getNext();
	} else {
	    DLLNode currentDLLNode = _head;
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



