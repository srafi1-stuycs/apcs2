//Shakil Rafi
//APCS2 pd4
//HW22 -- Stacks on Stacks on Stacks on Stacks...
//2017-03-22

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	_stack[_stackSize] = s;
	_stackSize++;
    }

    //means of removal
    public String pop( ) 
    { 
	_stackSize--;
	return _stack[_stackSize];
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
	return _stackSize == _stack.length;
    }

    public String toString() {
	String ret = "";
	for (int i = 0; i < _stackSize; i++) {
	    ret += _stack[i] + " ";
	}
	return ret;
    }

    public static void main(String[] args) {
	Latkes pancake = new Latkes(5);
	pancake.push("a");
	pancake.push("b");
	System.out.println(pancake);
	pancake.pop();
	System.out.println(pancake);
    }

}//end class Latkes

