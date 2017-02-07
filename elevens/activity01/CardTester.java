/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
	    Card bob = new Card("infinity and beyond", "potatoes", 13);
	    Card exploding = new Card("boom", "fuse", 5);
	    Card kittens = new Card("nyan", "poptart", 1);
	    System.out.println(bob);
	    System.out.println(exploding);
	    System.out.println(kittens);
	}
}
