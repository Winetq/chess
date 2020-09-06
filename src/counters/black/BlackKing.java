package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackKing extends BlackCounter {

    public BlackKing(Point coordinates) {
        super(coordinates, "black\\king.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square up
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square left catty-corner up
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y == potentialCoordinates.y) // movement one square left
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square left catty-corner down
            return true;
        if (this.coordinates.x == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement one square right catty-corner down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y == potentialCoordinates.y) // movement one square right
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement one square right catty-corner up
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "BlackKing(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
