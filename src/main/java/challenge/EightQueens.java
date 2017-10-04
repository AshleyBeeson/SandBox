package challenge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EightQueens {


    public static void main(String[] args) {

        /*
         * The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other.
         * Thus, a solution requires that no two queens share the same row, column, or diagonal.
         * The eight queens puzzle is an example of the more general n queens problem of placing n non-attacking queens on an n×n chessboard,
         * for which solutions exist for all natural numbers n with the exception of n=2 and n=3.[1]
         */

        int queensToPlace = 2;
        int xDimension = 3, yDimension = 3;

        StringBuilder build = new StringBuilder();
        Grid grid = new Grid(xDimension, yDimension);
        System.out.println("Starting Calculations");
        int count = 0;
        long startTime = System.currentTimeMillis();
        while (queensToPlace > 0) {
            for (int i = 0; i < xDimension; i++) {
                for (int j = 0; j < yDimension; j++) {
                    String placement = grid.checkQueenPlacement(grid.getGridPoint(i, j));
                    if (placement.toLowerCase().contains("placed")) {
                        queensToPlace--;
                        build.append(placement);
                    }
                }
            }
//            build.append(String.format("Queens Left to place: %d\n", queensToPlace));
//            if (count % 10 == 0) {
//                System.out.println("Calculating...");
//            }
            count++;
            if (count > 100) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long secondsTaken = (endTime - startTime) / 1000;
        build.append(String.format("#### Queens Unplaced = %d #### \n Time taken = %d", queensToPlace, secondsTaken));
        build.append("\n");
        build.append(grid.displayGrid());
        outToFile(build, "Eight_Queens_Output");


    }

    private static void outToFile(StringBuilder build, String fileName) {
        String filePath = System.getProperty("user.dir");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath + File.separatorChar + fileName);
            bw = new BufferedWriter(fw);
            bw.write(build.toString());
            System.out.println("Done writing output");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
