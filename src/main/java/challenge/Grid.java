package challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {

    private Map<String, GridPoint> gridPoints;
    private int xSize, ySize;

    public Grid(int xDimension, int yDimension) {
        gridPoints = new HashMap<String, GridPoint>();
        xSize = xDimension;
        ySize = yDimension;
        for (int i = 0; i < xDimension; i++) {
            for (int j = 0; j < yDimension; j++) {
                gridPoints.put(i + "," + j, new GridPoint(i, j));
            }
        }

    }

    public GridPoint getGridPoint(int x, int y) {
        return gridPoints.get(String.format("%d,%d", x, y));
    }

    public String displayGrid() {
        StringBuilder buff = new StringBuilder();
        for (Map.Entry entry : gridPoints.entrySet()) {
            GridPoint point = (GridPoint) entry.getValue();
            buff.append(String.format("Point:%d,%d hasQueen:%s \n", point.getXPosition(), point.getYPosition(), point.hasQueen));
        }
        return buff.toString();
    }

    public void placeQueen(int x, int y) {
        String key = String.format("%d,%d", x, y);
        GridPoint point = gridPoints.get(key);
        point.setHasQueen(true);
    }

    public String checkQueenPlacement(GridPoint placementPoint) {
        if (!placementPoint.hasQueen) {
            int xPosition = placementPoint.xPosition;
            int yPosition = placementPoint.yPosition;
            boolean place = checkVertical(xPosition) && checkHorizontal(yPosition) && checkDiagonalRight()
                    && checkDiagonalLeft();
            if (place) {
                placeQueen(xPosition, yPosition);
                return String.format("Placed at %d,%d \n", xPosition, yPosition);
            } else {
                return "Queen can't be positioned here \n";
            }
        } else {
            return "Point already has a queen \n";
        }
    }

    private boolean checkHorizontal(int yPosition) {
        for (int i = 0; i < xSize; i++) {
            GridPoint gridPoint = gridPoints.get(String.format("%d,%d", i, yPosition));
            if (gridPoint.hasQueen) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVertical(int xPosition) {
        for (int i = 0; i < ySize; i++) {
            GridPoint gridPoint = gridPoints.get(String.format("%d,%d", xPosition, i));
            if (gridPoint.hasQueen) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonalRight() {
        List<String> points = calculateDiagonalXPoints();
        for (String point : points) {
            GridPoint gridPoint = gridPoints.get(point);
            if (gridPoint.hasQueen) {
                return false;
            }
        }
        return true;
    }

    private List<String> calculateDiagonalXPoints() {
        List<String> points = new ArrayList<String>();
        int c = 0;
//        System.out.println("X Diagonal");
        for (int i = xSize - 1; i > 0; i--) {
            points.add(i + "," + c);
            c++;
        }
//        System.out.println(points);
        return points;
    }

    private boolean checkDiagonalLeft() {
        List<String> points = calculateDiagonalYPoints();
        for (String point : points) {
            GridPoint gridPoint = gridPoints.get(point);
            if (gridPoint.hasQueen) {
                return false;
            }
        }
        return true;
    }

    private List<String> calculateDiagonalYPoints() {
        List<String> points = new ArrayList<String>();
        int c = ySize - 1;
//        System.out.println("Y Diagonal");
        for (int i = ySize - 1; i > -1; i--) {
            points.add(i + "," + c);
            c--;
        }
//        System.out.println(points);
        return points;
    }
}
