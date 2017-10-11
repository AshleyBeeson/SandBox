package challenge;

import lombok.Data;

import java.awt.*;

@Data
public class GridPoint {

    private Point position;
    private boolean queenPlaced;
    private boolean canQueenBePlaced;

    public GridPoint(int x, int y) {
        position = new Point();
        position.x = x;
        position.y = y;
        canQueenBePlaced = true;
    }

    public boolean canQueenBePlaced() {
        return canQueenBePlaced;
    }

    public String getPos() {
        return String.format("%d,%d", position.x, position.y);
    }


}
