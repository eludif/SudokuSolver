public class SudokuSimulation {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 7, 0, 5, 0, 0, 0, 0},
                {8, 6, 0, 0, 3, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 2, 0, 3},
                {0, 8, 0, 0, 0, 7, 4, 0, 2},
                {0, 0, 1, 0, 0, 0, 8, 0, 0},
                {2, 0, 9, 5, 0, 0, 0, 7, 0},
                {9, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 9, 8, 0, 0, 4, 7},
                {0, 0, 0, 0, 1, 0, 9, 0, 0}
        };
        SudokuGrid.printGrid(board);
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        SudokuGrid.printGrid(board);
    }
}
