package counters.white;

import abstraction.Counter;
import abstraction.WhiteCounter;

import java.awt.Point;

public class WhiteBishop extends WhiteCounter {

    public WhiteBishop(Point coordinates) {
        super(coordinates, "white\\bishop.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (Math.abs(this.coordinates.x - potentialCoordinates.x) == Math.abs(this.coordinates.y - potentialCoordinates.y)) // left catty-corner or right catty-corner
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "WhiteBishop(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
