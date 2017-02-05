public class CodingBat  {
    public int factorial(int n) {
	if (n < 1)
	    return 1;
	else 
	    return n*factorial(n-1);
    }

    public int bunnyEars(int bunnies) {
	if (bunnies < 1)
	    return 0;
	else
	    return 2 + bunnyEars(bunnies - 1);
    }
    
    public int fibonacci(int n) {
	if (n == 0)
	    return 0;
	if (n < 3)
	    return 1;
	else
	    return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public int bunnyEars2(int n) {
	if (n == 0)
	    return 0;
	if (n % 2 == 0)
	    return 3 + bunnyEars2(n - 1);
	else
	    return 2 + bunnyEars2(n - 1);
    }

    public int triangle(int n) {
	if (n < 1)
	    return 0;
	else if (n == 1)
	    return 1;
	else
	    return 2 + triangle(n - 1);
    }

    public static void main(String[] args) {
	
    }

}
