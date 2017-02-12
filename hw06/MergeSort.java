//Shakil Rafi
//APCS2 pd4
//hw06 - Split, Merge, Sorted

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: Split given array in half until there is only 1 element in the array. One-element arrays are already sorted, so simply return them. Merge each half of each split so that it ends up sorted (take the smallest of either array until both are echausted). Once the original array has been merged, it will be sorted.

  ======================================*/

public class MergeSort {

    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] ret = new int[a.length + b.length];
	int indexA = 0;
	int indexB = 0;
	for (int i = 0; i < ret.length; i++) {
	    if (indexB == b.length || (indexA < a.length && a[indexA] < b[indexB])) {
		ret[i] = a[indexA];
		indexA++;
	    } else {
		ret[i] = b[indexB];
		indexB++;
	    }
	}
	return ret;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length < 2)
	    return arr;
	else {
	    int[] a = new int[arr.length/2];
	    int[] b = new int[arr.length - arr.length/2];
	    for (int i = 0; i < a.length; i++)
		a[i] = arr[i];
	    for (int i = 0; i < b.length; i++)
		b[i] = arr[a.length + i];
	    a = sort(a);
	    b = sort(b);
	    return merge(a, b);
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }
    
    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort

