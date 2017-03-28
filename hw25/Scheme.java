//Shakil Rafi
//APCS2 pd4
//HW 25 -- What a Racket
//2017-03-27

/******************************************************
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 * Create a stack for numbers, operations, and number of numbers
 * Go through th array of tokens, adding operations and numbers to their stacks
 * Each time you encounter an open paren, push 0 to the numOfNums stack
 * When you encounter more numbers, add one to that number
 * When you encounter a close paren, evaluate by popping from ops and popping
   as many numbers as indicated by popping from numOfNums
 * Push the result to the stack
 * Return the last remaining number from nums
 *
 * STACK OF CHOICE: LLStack b/c it is more efficient in storing new entries
 ******************************************************/

public class Scheme  {

    public static String[] tokenize(String exp) {
	return exp.split("\\s+");
    }

    public static Double parse(String s) {
	String[] tokens = tokenize(s);
	LLStack<String> ops = new LLStack<String>();
	LLStack<Double> nums = new LLStack<Double>();
	LLStack<Integer> numNums = new LLStack<Integer>();
	for (int i = 0; i < tokens.length; i++) {
	    char c = tokens[i].charAt(0);
	    if (c == ')') {
		char op = ops.pop().charAt(0);
		Double temp = nums.pop();
		int lim = numNums.pop();
		if (op == '+') {
		    for (int j = 0; j < lim - 1; j++) {
			temp += nums.pop();
		    }
		} else if (op == '-') {
		    temp *= -1;
		    for (int j = 0; j < lim - 1; j++) {
			temp -= nums.pop();
		    }
		    temp += nums.pop();
		} else if (op == '*') {
		    for (int j = 0; j < lim - 1; j++) {
			temp *= nums.pop();
		    }
		}
		nums.push(temp);
		if (!numNums.isEmpty())
		    numNums.push(numNums.pop() + 1);
	    } else if (c == '(') {
		numNums.push(0);
	    } else if (c == '+' || c == '-' || c == '*') {
		ops.push(c+"");
	    } else {
		nums.push(Double.parseDouble(tokens[i]));
		numNums.push(numNums.pop() + 1);
	    }
	}
	return nums.pop();
    }
    
    public static void main(String[] args) {
	System.out.println(parse("( + 1 2 )"));
	System.out.println(parse("( + ( * 3 2 ) 2 )"));
	System.out.println(parse("( + 4 ( - 2 1 ) )"));
    }
    
}
