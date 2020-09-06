package counters.white;

import abstraction.Counter;
import abstraction.WhiteCounter;

import java.awt.Point;

public class WhitePawn extends WhiteCounter {

    public WhitePawn(Point coordinates) {
        super(coordinates, "white\\pawn.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        // white pawns
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter == null) // movement one square up
            return true;
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y
                && this.coordinates.y == 6 && attackedCounter == null) // movement two squares up
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square left catty-corner
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square right catty-corner
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "WhitePawn(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
