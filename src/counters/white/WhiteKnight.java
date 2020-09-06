package counters.white;

import abstraction.Counter;
import abstraction.WhiteCounter;

import java.awt.Point;

public class WhiteKnight extends WhiteCounter {

    public WhiteKnight(Point coordinates) {
        super(coordinates, "white\\knight.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square right and two squares up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares right and one square up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares right and one square down
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square right and two squares down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square left and two squares down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares left and one square down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares left and one square up
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square left and two squares up
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "WhiteKnight(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
