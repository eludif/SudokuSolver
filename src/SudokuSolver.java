class SudokuSolver {

    // Returns a boolean which indicates whether any assigned entry
    // in the specified row matches the given number.
    private boolean usedInRow(int[][] board, int row, int num){
        for (int col = 0; col < board.length; col++){
            if (board[row][col] == num){
                return true;
            }
        }
        return false;
    }

    // Returns a boolean which indicates whether any assigned entry
    // in the specified column matches the given number.
    private boolean usedInCol(int[][] board, int col, int num){
        for (int[] aBoard : board) {
            if (aBoard[col] == num) {
                return true;
            }
        }
        return false;
    }

    // Returns a boolean which indicates whether any assigned entry
    // within the specified 3x3 box matches the given number.
    private boolean usedInBox(int board[][], int box_start_row, int box_start_col, int num)
    {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (board[row + box_start_row][col + box_start_col] == num)
                {
                    return true;
                }
        return false;
    }

    // Returns a boolean which indicates whether it will be legal to assign
    // num to the given row,col location.
    private boolean isSafe(int board[][], int row, int col, int num)
    {
        // Check if 'num' is not already placed in current row,
        // current column and current 3x3 box
        return !usedInRow(board, row, num) &&
                !usedInCol(board, col, num) &&
                !usedInBox(board, row - row % 3, col - col % 3, num);
    }

    // Searches the grid to find an entry that is still unassigned. If
    // found, the reference parameters row, col will be set the location
    // that is unassigned, and true is returned. If no unassigned entries
    // remain, false is returned.
    private Pair<Integer, Integer> getUnassignedLocation(int[][] board)
    {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (board[row][col] == SudokuGrid.BLANK)
                {
                    return new Pair<>(row, col);
                }
        return SudokuGrid.GRID_FULL;
    }

    // Takes a partially filled-in grid and attempts to assign values to
    // all unassigned locations in such a way to meet the requirements
    // for Sudoku solution (non-duplication across rows, columns, and boxes)
    boolean solveSudoku(int board[][]){
        // If the Soduko grid has been filled, we are done
        if (SudokuGrid.GRID_FULL == getUnassignedLocation(board))
        {
            return true;
        }

        // Get an unassigned Sudoku grid location
        Pair<Integer, Integer> rowAndCol = getUnassignedLocation(board);
        int row = rowAndCol.getFirst();
        int col = rowAndCol.getSecond();

        // Consider digits 1 to 9
        for (int num = 1; num <= 9; num++)
        {
            // If placing the current number in the current
            // unassigned location is valid, go ahead
            if (isSafe(board, row, col, num))
            {
                // Make tentative assignment
                board[row][col] = num;

                // Do the same thing again recursively. If we go
                // through all of the recursions, and in the end
                // return true, then all of our number placements
                // on the Soduko grid are valid and we have fully
                // solved it
                if (solveSudoku(board))
                {
                    return true;
                }

                // As we were not able to validly go through all
                // of the recursions, we must have an invalid number
                // placement somewhere. Lets go back and try a
                // different number for this particular unassigned location
                board[row][col] = SudokuGrid.BLANK;
            }
        }
        // If we have gone through all possible numbers for the current unassigned
        // location, then we probably assigned a bad number early. Lets backtrack
        // and try a different number for the previous unassigned locations.
        return false;
    }
}
