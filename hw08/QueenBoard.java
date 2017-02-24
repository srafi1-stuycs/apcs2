//Shakil Rafi
//APCS2 pd4
//HW08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2017-02-22

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
     * 1. Start on one column
     * 2. Add a queen to the first row of that column
     * 3. Recursively go to the next column
     *   a. If the column exceeds the size of the board, that is a solution
     *   b. If there are no valid rows to place a queen, go back one move
     */
    public boolean solve()
    {
	return solveH(0);
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if (col == _board.length) {
	    printSolution();
	    return true;
	}
	boolean ret = false;
	for (int i = 0; i < _board.length; i++) {
	    if (!addQueen(i, col)) {
		continue;
	    }
	    if (solveH(col + 1))
		ret = true;
	    removeQueen(i, col);
	}
	return ret;
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
	System.out.println();
    }

    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a queen to the board and denotes all horizontal and diagonal positions as invalid
     * precondition: _board has been initialized
     * postcondition: change the value at given position to 1
     *                decrement all horizontal and diagonal positions
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

	// go through each position horizontal, and diagonal from the given position in which the queen was placed
	while(col+offset < _board[row].length) {
	    // decrement each position in the column
	    _board[row][col+offset]--;

	    // decrement each position diagonally
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // move on to one more position away
	    offset++;
	}
	return true;
    }


    /***
     * Removes a queen from the board and adjusts all horizontal and diagonal positions 
     * precondition: _board has been initialized
     * postcondition: change the value at given position to 0
     *                increment all horizontal and diagonal positions
     */
    private boolean removeQueen(int row, int col)
    {
	// check if there is actually a queen in the given position 
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// set the position to 0 (no queen)
	int offset = 1;	        // set initial offset 

	// increment each position on the horizontal and diagonals
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
     * Renders a string version of the object
     * precondition: _board has been initialized
     * postcondition: String of all positions and their int values
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
	QueenBoard a;
	for (int i = 1; i < 5; i++) {
	    a = new QueenBoard(i);
	    if (a.solve()) {
		System.out.println("Solution(s) found for n=" + i);
	    } else {
		System.out.println("No solutions for n=" + i);
	    }
	}	
	
	QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
    }//end main()
    
}//end class
