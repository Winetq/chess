package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackBishop extends BlackCounter {

    public BlackBishop(Point coordinates) {
        super(coordinates, "black\\bishop.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (Math.abs(this.coordinates.x - potentialCoordinates.x) == Math.abs(this.coordinates.y - potentialCoordinates.y)) // left catty-corner or right catty-corner
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "BlackBishop(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
