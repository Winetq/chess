package abstraction;

import java.awt.Point;

public abstract class Counter {
    protected Point coordinates;
    protected String path;
    protected boolean isAlive;

    public Counter(Point coordinates, String path) {
        this.coordinates = coordinates;
        this.path = path;
        this.isAlive = true;
    }

    public void move(Point newCoordinates){
        this.coordinates = newCoordinates;
    }

    public void battle(Counter attackedCounter){
        if (attackedCounter != null)
            attackedCounter.setAlive(false);
    }

    public abstract boolean isAllowedMove(Point potentialCoordinates, Counter attackedCounter);

    public int getX() {
        return coordinates.x;
    }

    public int getY(){
        return coordinates.y;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public String getPath() {
        return path;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
