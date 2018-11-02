class SudokuGrid {
    private final static int DIM = 9;
    final static int BLANK = 0;
    private final static String SPACE = " ";
    private final static String LINE = "|";
    private final static String NEW_ROW = "-------------------------------------";
    final static Pair<Integer, Integer> GRID_FULL = new Pair<>(DIM,DIM);

    static void printGrid(int[][] board){
        for (int[] aBoard : board) {
            System.out.println(SPACE + SPACE + SPACE + SPACE);
            System.out.println(NEW_ROW);
            for (int anABoard : aBoard) {
                System.out.print(SPACE);
                if (BLANK == anABoard)
                    System.out.print(SPACE);
                else
                    System.out.print(anABoard);
                System.out.print(SPACE);
                System.out.print(LINE);
            }
        }
        System.out.println();
        System.out.println(NEW_ROW);
        System.out.println();
    }

}
