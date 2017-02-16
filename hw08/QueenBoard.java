/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * [...]
     */
    public boolean solve()
    {
	return false;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	for (int[] row : _board) {
	    for (int p : row) {
		if (p < 1)
		    System.out.print('-');
		else
		    System.out.print('Q');
	    }
	    System.out.println();
	}
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    private boolean addQueen(int row, int col)
    {
	// Check if the given position is empty
	if(_board[row][col] != 0){
	    return false;
	}

	// Add a queen at the given position
	_board[row][col] = 1;

	// variable to help access positions queen is attacking
	int offset = 1;

	// go through each position vertical, horizontal, and diagonal from the given position in which the queen was placed
	while(col+offset < _board[row].length) {
	    // ?
	    _board[row][col+offset]--;

	    // ?
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // ?
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    private boolean removeQueen(int row, int col)
    {
	// ?
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// ?
	int offset = 1;	        // ?

	// ?
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
    }//end main()
    
}//end class
