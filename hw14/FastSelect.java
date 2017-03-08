//Shakil Rafi
//APCS1 pd4
//HW14 -- So so fast
//2017-03-07

public class FastSelect  {

    /*
      Splits an array into 2 sections (not necessarily equal)
      Each section contains the values above or below the Yth term
      If the pivot point is the Yth term (ie: partition method returns y - 1)
        then return that number
      If y is less than this number, it must be in the section of smaller nums
      If y is greater, it must be in the sectin of greater nums
      Search through the appropriate section of the array recursivly
     */
    public static int getYth(int[] arr, int y, int start, int end) {
	int n = partitionSort(arr, start, end, (start+end)/2);
	if (y == n) {
	    return arr[n];
	} else if (y < n) {
	    return getYth(arr, y, start, n);
	} else {
	    return getYth(arr, y, n, end);
	}
    }

    //wrapper method for getYth
    public static int getYth(int[] arr, int y) {
	return getYth(arr, y - 1, 0, arr.length - 1);
    }

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

	int[] ordered = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	int[] arr;
	int n;
	
	if (args.length == 1) {
	    n = Integer.parseInt(args[0]);
	    arr = ordered;
	} else if (args.length > 3) {
	    arr = new int[args.length];
	    for (int i = 0; i < args.length - 1; i++) {
		arr[i] = Integer.parseInt(args[i]);
	    }
	    n = Integer.parseInt(args[args.length-1]);
	} else {
	    arr = genRandomArray(10);
	    n = (int) (Math.random()*10);
	}

	System.out.print("Array: ");
	printArr(arr);
	System.out.println(n + "th element: " + getYth(arr, n));
	System.out.print("Updated array: ");
	printArr(arr);
    }

}
