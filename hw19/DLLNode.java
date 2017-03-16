public class DLLNode<T> 
{
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode; //pointer to next LLNode
    private DLLNode<T> _prevNode; //pointer to previous LLNode

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode<T> prev, DLLNode<T> next ) 
    {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }

    public DLLNode<T> getPrev() { return _prevNode; }

    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) 
    {
	T oldCargo = _cargo;
	_cargo = newCargo;
	return oldCargo;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) 
    {
	DLLNode<T> oldNode = _nextNode;
	_nextNode = newNext;
	return oldNode;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ) 
    {
	DLLNode<T> oldNode = _prevNode;
	_prevNode = newPrev;
	return oldNode;
    }
    //--------------^  MUTATORS  ^--------------

    // override inherited toString
    public String toString() { return _cargo.toString(); }
}
