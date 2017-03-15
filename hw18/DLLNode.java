public class DLLNode 
{
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next LLNode
    private DLLNode _prevNode; //pointer to previous LLNode

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode prev, DLLNode next ) 
    {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }

    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) 
    {
	String oldCargo = _cargo;
	_cargo = newCargo;
	return oldCargo;
    }

    public DLLNode setNext( DLLNode newNext ) 
    {
	DLLNode oldNode = _nextNode;
	_nextNode = newNext;
	return oldNode;
    }

    public DLLNode setPrev( DLLNode newPrev ) 
    {
	DLLNode oldNode = _prevNode;
	_prevNode = newPrev;
	return oldNode;
    }
    //--------------^  MUTATORS  ^--------------

    // override inherited toString
    public String toString() { return _cargo.toString(); }
}
