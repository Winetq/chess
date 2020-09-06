package counters.white;

import abstraction.Counter;
import abstraction.WhiteCounter;

import java.awt.Point;

public class WhiteQueen extends WhiteCounter {

    public WhiteQueen(Point coordinates) {
        super(coordinates, "white\\queen.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (Math.abs(this.coordinates.x - potentialCoordinates.x) == Math.abs(this.coordinates.y - potentialCoordinates.y)) // left catty-corner or right catty-corner
            return true;
        if (this.coordinates.x == potentialCoordinates.x || this.coordinates.y == potentialCoordinates.y) // vertically or horizontally
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "WhiteQueen(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
