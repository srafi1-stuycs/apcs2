//Shakil Rafi
//APCS1 pd4
//HW13 -- We Be Dem
//2017-03-06

public class Mysterion  {

    /*
      Looks through a part of a list such that the element at index c
      ends up at its final position (for sorting)
      The rest of the numbers are also somewhat more sorted
     */
    public static int partitionSort(int[] arr, int start, int end, int c) {
	int v = arr[c];
	swap(arr, end, c);
	int s = start;
	for (int i = start; i < end; i++) {
	    if (arr[i] < v) {
		swap(arr, s, i);
		s += 1;
	    }
	}
	swap(arr, end, s);
	return s;
    }

    public static void swap(int[] arr, int a, int b) {
	int c = arr[a];
	arr[a] = arr[b];
	arr[b] = c;
    }

    public static void printArr(int[] arr) {
	for (int i : arr)
	    System.out.print(i + " ");
	System.out.println();
    }

    public static void test(int[] arr) {
	int a = 0;
	int b = arr.length - 1;
	int c = arr.length/2;
	System.out.print("Start: ");
	printArr(arr);
	System.out.println("a=" + a + ", b=" + b + ", c=" + c);
	System.out.println("Returns: " + partitionSort(arr, a, b, c));
	System.out.print("End: ");
	printArr(arr);
	System.out.println();
    }

    public static int[] genRandomArray(int n) {
	int[] arr = new int[n];
	for (int i = 0; i < n; i++) {
	    arr[i] = (int) (Math.random()*20);
	}
	return arr;
    }
    
    public static void main(String[] args) {
	int[] a = {1, 2, 3, 4, 5};
	test(a);
	int[] b = {5, 4, 3, 2, 1};
	test(b);
	int[] c = {2, 3, 1, 3, 4};
	test(c);

	if (args.length == 1) {
	    int n = Integer.parseInt(args[0]);
	    test(genRandomArray(n));
	} else if (args.length > 1) {
	    int[] arr = new int[args.length];
	    for (int i = 0; i < args.length; i++) {
		arr[i] = Integer.parseInt(args[i]);
	    }
	    test(arr);
	} else
	    test(genRandomArray(5));
    }

}
