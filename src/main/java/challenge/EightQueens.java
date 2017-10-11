package challenge;

import java.util.*;

public class EightQueens {


    public static void main(String[] args) {

        /*
         * The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other.
         * Thus, a solution requires that no two queens share the same row, column, or diagonal.
         * The eight queens puzzle is an example of the more general n queens problem of placing n non-attacking queens on an n×n chessboard,
         * for which solutions exist for all natural numbers n with the exception of n=2 and n=3.[1]
         */

        //Add first queen
        //Calculate other queen positions

        EightQueens eightQueens = new EightQueens();
        int challengeSize = 4;
        Map<String, GridPoint> board = eightQueens.setUpBoard(challengeSize);
        System.out.println("Initial Board");
        eightQueens.displayBoard(board);
        board.get("0,0").setQueenPlaced(true);
        System.out.println("\nAfter first queen");
        eightQueens.displayBoard(board);
        eightQueens.updateBoard(board, challengeSize);
        System.out.println("\nFirst Update of board");
        eightQueens.displayBoard(board);

    }

    private void updateBoard(Map<String, GridPoint> board, int size) {
        List<String> posToUpdate = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                GridPoint gridPoint = board.get(String.format("%s,%s", i, j));
                if (gridPoint.isQueenPlaced()) {
                    gridPoint.setCanQueenBePlaced(false);
                    calculate(gridPoint, posToUpdate, size);
                }
            }
        }
        update(board, posToUpdate);
    }

    private void update(Map<String, GridPoint> board, List<String> posToUpdate) {
        for (String pos : posToUpdate) {
            board.get(pos).setCanQueenBePlaced(false);
        }
    }

    private void calculate(GridPoint gridPoint, List<String> posToUpdate, int size) {
        int x = gridPoint.getPosition().x;
        int y = gridPoint.getPosition().y;
        int row = 0, column = 0;
        //------
        while (row < size) {
            posToUpdate.add(String.format("%s,%s", row, y));
            row++;
        }

        /*
        * |
        * |
        * |
        * |*/
        while (column < size) {
            posToUpdate.add(String.format("%s,%s", x, column));
            column++;
        }

        column = 0;
        row = 0;
        //````////////
        // -y+x (+y-x)


        //````\\\\\\\
        //-y-x (+y+x)

    }

    private void displayBoard(Map<String, GridPoint> board) {
        Collection<GridPoint> values = board.values();
        for (GridPoint value : values) {
            System.out.println(String.format("Location: %s -- hasQueen: %b -- canQueenBePlaced: %b", value.getPos(), value.isQueenPlaced(), value.canQueenBePlaced()));
        }
    }


    private Map<String, GridPoint> setUpBoard(int size) {
        Map<String, GridPoint> grid = new HashMap<String, GridPoint>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid.put(String.format("%d,%d", i, j), new GridPoint(i, j));
            }
        }
        return grid;
    }
}
