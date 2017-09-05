package challenge;


import lombok.Data;

@Data
public class GridPoint {

    public int xPosition, yPosition;

    public boolean hasQueen;

    public GridPoint(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

}
