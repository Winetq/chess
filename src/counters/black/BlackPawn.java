package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackPawn extends BlackCounter {

    public BlackPawn(Point coordinates) {
        super(coordinates, "black\\pawn.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        // black pawns
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y
                && attackedCounter == null) // movement one square down
            return true;
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y
                && this.coordinates.y == 1 && attackedCounter == null) // movement two squares down
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square left catty-corner
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y
                && attackedCounter != null) // movement one square right catty-corner
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "BlackPawn(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
