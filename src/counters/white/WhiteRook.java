package counters.white;

import abstraction.Counter;
import abstraction.WhiteCounter;

import java.awt.Point;

public class WhiteRook extends WhiteCounter {

    public WhiteRook(Point coordinates) {
        super(coordinates, "white\\rook.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x == potentialCoordinates.x || this.coordinates.y == potentialCoordinates.y) // vertically or horizontally
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "WhiteRook(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
