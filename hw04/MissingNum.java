//Team Derivative
//Shakil Rafi and Alitquan Malick
//APCS2 pd4
//HW04 -- Where In the Array Is Carmen San Numero?
//2017-02-05

/*
  This algorithm utilizes equations to find the missing number in linear runtime.
  First, get the "ideal" sum of the sequence which includes all numbers 1 through n without any duplicates or missing numbers.
  The algorithm utiliizes the arithmetic sum formula to evaluate this: n*(1+n)/2.
  Next, subtract all of the numbers in the actual sequence from the sum.
  All numbers that are not duplicates wll be canceled out and you will end up with diff=(missingNum - duplicateNum).
  This expression has two variables, so we need another equation.
  We can get this equation using products.
  Multiply all of the numbers in the "ideal" sequence and divide by the numbers in the actual sequence.
  Again, all non-duplicates are canceled out and you are now left with mult=(missingNum/duplicateNum).
  Now, we can isolate the dulicate number to substitute and solve for the missing number.
  We get the equations:
  duplicateNum = missingNum - diff
  duplicateNum = missingNum/mult
  Now, to get a universal expression for missingNum, we just solve:
  missingNum - diff = missingNum/mult
  mult*missingNum - mult*diff = missingNum
  mult*missingNum - missingNum = mult*diff
  missingNum*(mult - 1) = mult*diff
  misingNum = (mult*diff)/(mult - 1)
  diff and mult were determined above, so we just need to plug in these values to dtermine the missing number.
 */

public class MissingNum  {
    
    public static int missingNum(int[] arr) {
	//a = missing number, b = duplicate number
	int n = arr.length;
	int diff =n*(1+n)/2;
	for (int i : arr)
	    diff -= i;
	//diff = a - b
	double mult = 1;
	for (int i = 1; i <= n; i++) {
	    mult *= i;
	    mult /= arr[i - 1];
	}
	//mult = a/b
	//a/mult = a - diff
	return (int) Math.round(diff*mult/(mult - 1));
    }
    
    public static void main(String[] args) {
	int[] a = {2,2}; //1
	int[] b = {1, 2, 2}; //3
	int[] c = {1, 3, 3}; //2 
	int[] d = {2, 1, 1}; //3
	int[] e = {2, 3, 3}; //1
	int[] f = {3, 1, 1}; //2
	int[] g = {3, 2, 2}; //1
	int[] h = {2, 3, 1, 1, 5}; //4
	System.out.println(missingNum(a));
	System.out.println(missingNum(b));
	System.out.println(missingNum(c));
	System.out.println(missingNum(d));
	System.out.println(missingNum(e));
	System.out.println(missingNum(f));
	System.out.println(missingNum(g));
	System.out.println(missingNum(h));
    }

}
