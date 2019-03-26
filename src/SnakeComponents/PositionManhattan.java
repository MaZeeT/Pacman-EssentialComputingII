package SnakeComponents;

/**
 * The purpose of this class is to extend the Position class to be able to handle distance between two positions by calculating a Manhattan distance.
 *
 * @author MaZeeT
 */
public class PositionManhattan extends Position {

    private int distance;

    /**
     * Initial with x and y coordinates.
     *
     * @param x The x position of this object's position.
     * @param y The y position of this object's position.
     */
    public PositionManhattan(int x, int y) {
        super(x, y);
    }

    /**
     * Initial with a Position object.
     *
     * @param position The position this object.
     */
    public PositionManhattan(Position position) {
        super(position.getX(), position.getY());
    }

    /**
     * This will calculate the distance in a Manhattan way, so we get a always positive int, where the different in X and Y position is added together.
     *
     * @param otherPos The position the distance will be calculated to.
     * @return Return the distance to the given position.
     */
    public int getDistanceTo(Position otherPos) {
        distance = distanceTo(otherPos);
        return distance;
    }

    /**
     * This will calculate the distance in a Manhattan way, so we get a always positive int, where the different in X and Y position is added together.
     *
     * @param x The other's x position.
     * @param y The other's y position.
     * @return Returns the distance between the two positions.
     */
    public int getDistanceTo(int x, int y) {
        distance = distanceTo(x, y);
        return distance;
    }


    /**
     * This will calculate the distance in a Manhattan way, based on a given position.
     *
     * @param otherPos The other's position.
     * @return Return the distance to the given position.
     */
    private int distanceTo(Position otherPos) {
        return distanceTo(otherPos.getX(), otherPos.getY());
    }

    /**
     * This will calculate the distance in a Manhattan way, so we get a always positive int, where the different in X and Y position is added together.
     *
     * @param otherX The other's x position
     * @param otherY The other's y position
     * @return Return the distance to the given position.
     */
    private int distanceTo(int otherX, int otherY) {
        int deltaX = Math.abs(this.getX() - otherX);
        int deltaY = Math.abs(this.getY() - otherY);
        return deltaX + deltaY;
    }

}
