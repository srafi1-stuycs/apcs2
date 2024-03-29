public class MatrixSearch  {

    public static String matrixSearch(int[][] arr, int n) {
	int x = 0;
	int y = arr.length - 1;

	while (x <= arr.length - 1 && y >= 0) {
	    if (arr[y][x] == n) {
		return "(" + x + "," + y + ")";
	    } else if (arr[y][x] < n) {
		y--;
	    } else {
		x++;
	    }
	}
	return "(-1,-1)";
    }
    
    public static void main(String[] args) {
	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 5, 12, 15 },
	};
	System.out.println(matrixSearch(bey, 7));
	System.out.println(matrixSearch(bey, 3));
	System.out.println(matrixSearch(bey, 12));
    }
}
