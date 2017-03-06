//Shakil Rafi
//APCS1 pd4
//HW13 -- We Be Dem
//2017-03-06

public class Mysterion  {

    public static int mysterion(int[] arr, int a, int b, int c) {
	int v = arr[c];
	swap(arr, b, c);
	int s = a;
	for (int i = a; i < b; i++) {
	    if (arr[i] < v) {
		swap(arr, s, i);
		s += 1;
	    }
	    printArr(arr);
	}
	swap(arr, b, s);
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
	int c = 2;
	System.out.print("Start: ");
	printArr(arr);
	System.out.println("a=" + a + ", b=" + b + ", c=" + c);
	System.out.println("Returns: " + mysterion(arr, 0, arr.length - 1, 3));
	System.out.print("End: ");
	printArr(arr);
    }

    public static void main(String[] args) {
	int[] a = {5, 4, 17, 90, 6};
	test(a);
    }

}
