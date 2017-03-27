public class Racket  {

    public static String[] tokenize(String exp) {
	return exp.split("\\s+");
    }

    public static String parse(String s) {
	String[] tokens = tokenize(s);
	LLStack<Integer> parens = new LLStack<Integer>();
	LLStack<String> ops = new LLStack<String>();
	LLStack<Double> nums = new LLStack<Double>();
	for (int i = 0; i < tokens.length; i++) {
	    char c = tokens[i].getChar(0);
	    if (c == ')') {
		char op = ops.pop(),charAt(0);
		if (op == '+') {
		    Double temp = nums.pop();
		    int lim = parens.pop();
		    for (int j = i;
		}
	    } else if (c == '(') {
		parens.push(i);
	    } else if (c == '+' || c == '-' || c == '*') {
		ops.push(c+"");
	    } else {
		nums.push(Double.parseDouble(tokens[i]);
	    }
	}
    }
    
    public static void main(String[] args) {
	
    }
    
}
