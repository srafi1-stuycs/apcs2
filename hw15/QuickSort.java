//Shakil Rafi
//APCS2 pd4
//HW15 -- So so quick
//2017-03-08

/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. QuickSort algorithm:
 * Partition the given array such that all elements to the left of a given
 * element are less than that element and all elements to the right of it
 * are greater than it.
 * Afterwards, partition the upper half and lower half in the same way as the
 * original array until the upper and lower bounds collide (ie: you have
 * partitioned the enitre array)
 *
 * 2a. Worst pivot choice / array state and associated runtime:
 * The worst pivot creates a partition of one element and another parition
 * that is the original partition without one element
 *
 * 2b. Best pivot choice / array state and associated runtime:
 * The best pivot will partition the array into two equal parts (ie: you
 * divide the search space in half)
 *
 * 3. Approach to handling duplicate values in array:
 * Duplicate values are put right after the pivot and they do not mess up
 * the algorithm otherwise.
 *
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static void swap(int[] arr, int a, int b) {
	int c = arr[a];
	arr[a] = arr[b];
	arr[b] = c;
    }

    public static int partition(int[] arr, int start, int end, int pvtPos) {
	int v = arr[pvtPos];
	swap(arr, end, pvtPos);
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

    //--------------^  HELPER METHODS  ^--------------

    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
	qsort(d, 0, d.length - 1);
    }

    public static void qsort(int[] arr, int left, int right) {
	if (left < right) {
	    int pvtPos = partition(arr, left, right, left + 1);
	    qsort(arr, left, pvtPos - 1);
	    qsort(arr, pvtPos + 1, right);
	}
    }
    
    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.


    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
