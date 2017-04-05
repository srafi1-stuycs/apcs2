//Shakil Rafi
//APCS2 pd4
//HW29 -- Testing Deque
//2017-04-04

public class DequeTester  {

    public static void main(String[] args) {

	System.out.println("Testing front...");
	LLDeque<Integer> deck = new LLDeque<Integer>();
	System.out.println("Start: " + deck);
	for (int i = 0; i < 10; i++)
	    deck.addFront(i);
	System.out.println("After additions: " + deck);
	
	System.out.println("Removing...");
	for (int i = 0; i < 10; i++)
	    System.out.println(deck.removeFront());
	System.out.println("After deletions: " + deck);
	System.out.println();

	System.out.println("Testing end...");
	deck = new LLDeque<Integer>();
	System.out.println("Start: " + deck);
	for (int i = 0; i < 10; i++)
	    deck.addLast(i);
	System.out.println("After additions: " + deck);

	System.out.println("Peek front: " + deck.peekFront());
	System.out.println("Peek again: " + deck.peekFront());
	System.out.println("Peek last: " + deck.peekLast());
	System.out.println("Peek again: " + deck.peekLast());
	
	System.out.println("Removing...");
	for (int i = 0; i < 10; i++)
	    System.out.println(deck.removeLast());
	System.out.println("After deletions: " + deck);
    }

}
