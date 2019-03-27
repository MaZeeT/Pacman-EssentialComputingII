package Components;

/**
 * The purpose of this class is to extend the {@link Position} class to be able to handle distance between two {@link Position}s by calculating a Manhattan distance.
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
     * Initial with a {@link Position} object.
     *
     * @param position The {@link Position} this object.
     */
    public PositionManhattan(Position position) {
        super(position.getX(), position.getY());
    }

    /**
     * This will calculate the distance in a Manhattan way, so we get a always positive int, where the different in X and Y position is added together.
     *
     * @param otherPos The {@link Position} the distance will be calculated to.
     * @return Return the distance to the given {@link Position}.
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

    public int getDistance() {
        return distance;
    }

    /**
     * This will calculate the distance in a Manhattan way, based on a given {@link Position}.
     *
     * @param otherPos The other's {@link Position}.
     * @return Return the distance to the given {@link Position}.
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
        int deltaX = Math.abs(this.x - otherX);
        int deltaY = Math.abs(this.y - otherY);
        return deltaX + deltaY;
    }

    /**
     * Compare this {@link PositionManhattan} with any {@link Position} objects.
     * If the {@link Position} object is of type {@link PositionManhattan} the distance will be compared.
     * If the other {@link PositionManhattan} object has a lower distance -1 will be returned.
     * If the other {@link PositionManhattan} object has a higher distance +1 will be returned.
     * else compareTo from {@link Position} will be called and the result returned.
     *
     * @param otherPos The other compared {@link Position}.
     * @return Return -1, 0, +1 depending on if the other distance or position is greater, equal, or lower than the original {@link Position}.
     */
    @Override
    public int compareTo(Position otherPos) {
        if (otherPos instanceof PositionManhattan) {
            PositionManhattan other = (PositionManhattan) otherPos;
            if (distance < other.getDistance()) return +1;
            if (distance > other.getDistance()) return -1;
        }
        return super.compareTo(otherPos);
    }

}
