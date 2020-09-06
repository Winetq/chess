package counters.black;

import abstraction.BlackCounter;
import abstraction.Counter;

import java.awt.Point;

public class BlackKnight extends BlackCounter {

    public BlackKnight(Point coordinates) {
        super(coordinates, "black\\knight.png");
    }

    @Override
    public boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter) {
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square left and two squares up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares left and one square up
            return true;
        if (this.coordinates.x + 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares left and one square down
            return true;
        if (this.coordinates.x + 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square left and two squares down
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y + 2 == potentialCoordinates.y) // movement one square right and two squares down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y + 1 == potentialCoordinates.y) // movement two squares right and one square down
            return true;
        if (this.coordinates.x - 2 == potentialCoordinates.x && this.coordinates.y - 1 == potentialCoordinates.y) // movement two squares right and one square up
            return true;
        if (this.coordinates.x - 1 == potentialCoordinates.x && this.coordinates.y - 2 == potentialCoordinates.y) // movement one square right and two squares up
            return true;

        return false; // other cases
    }

    @Override
    public String toString() {
        return "BlackKnight(" + coordinates.x + ", " + coordinates.y + ")";
    }
}
