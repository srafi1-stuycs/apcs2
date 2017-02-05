// Team Binary
// Marcus Ng and Shakil Rafi
// APCS2 pd4
// HW2 -- I Am Still Searching
// 2017-2-2

/*
Our algorithm starts at the bottom left of the matrix.
The algorithm checks if the number at arr[row][column] is less than the
number being looked for (n). If it is, then the column is increased by 1.
If it is not, then the row is decreased by 1. As long as the row number is
not less than 0 and the column number does not go over arr.length-1, 
then the method will continue searching for the (column,row) of the number.
However, if the row or column goes out of bounds, then it will return (-1,-1)
because n was not found. The method returns a string of the coordinates 
(column,row) of n when n is found.
 */

public class MatrixFinder  {

    // Finds coordinates of n in matrix
    public static String matrixSearch(int[][] arr, int n) {
	String coords = "(-1,-1)";
	int column = 0;
	int row = arr.length - 1;
	
	// System.out.println("(" + column + "," + row + ")");

	// Row cannot be less than 0
	// Column cannot go over the length of the array - 1
	while (column <= arr.length - 1 && row >= 0) {
	    if (arr[row][column] == n) {
		coords = "(" + column + "," + row + ")";
		return coords;
	    } else if (arr[row][column] < n) {
		column++;
	    } else {
		row--;
	    }
	    // System.out.println("(" + column + "," + row + ")");
	}
	return coords;
    }
    
    public static void main(String[] args) {
	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 5, 12, 15 },
	};
	System.out.println(matrixSearch(bey, 7)); // (1,1)
	System.out.println(matrixSearch(bey, 3)); // (0,1) 
	System.out.println(matrixSearch(bey, 15)); // (2,2)
	System.out.println(matrixSearch(bey, 2)); // (-1,-1)

	int[][] burger = {
	    {-3, 0, 1},
	    {-2, 4, 5},
	    {-1, 5, 6}
	};
	System.out.println(matrixSearch(burger, 0)); // (1,0)
	System.out.println(matrixSearch(burger, -2)); // (0,1) 
	System.out.println(matrixSearch(burger, 5)); // (1,2)
	System.out.println(matrixSearch(burger, 2)); // (-1,-1)
    }
}
