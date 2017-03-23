//Shakil Rafi
//APCS2 pd4
//HW23 -- Stack: What is it good for?
//2017-03-23

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	Latkes ekacnap = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++) {
	    ekacnap.push("" + s.charAt(i));
	}
	String ret = "";
	for (int i = 0; i < s.length(); i++) {
	    ret += ekacnap.pop();
	}
	return ret;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    { 
	Latkes pancakes = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '(' || c == '{' || c == '[') {
		pancakes.push("" + c);
	    } else {
		if (pancakes.isEmpty())
		    return false;
		char open = pancakes.pop().charAt(0);
		boolean paren = open == '(' && c == ')';
		boolean curly = open == '{' && c == '}';
		boolean square = open == '[' && c == ']';
		if (!(paren || curly || square))
		    return false;
	    }
	}
	return pancakes.isEmpty();
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    }

}//end class LatKtS
