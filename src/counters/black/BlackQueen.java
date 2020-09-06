package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackQueen extends BlackCounter {

    public BlackQueen(Point coordinates) {
        super(coordinates, "black\\queen.png");
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
        return "BlackQueen(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
