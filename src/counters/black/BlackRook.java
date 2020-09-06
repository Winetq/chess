package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackRook extends BlackCounter {

    public BlackRook(Point coordinates) {
        super(coordinates, "black\\rook.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x == potentialCoordinates.x || this.coordinates.y == potentialCoordinates.y) // vertically or horizontally
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "BlackRook(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
