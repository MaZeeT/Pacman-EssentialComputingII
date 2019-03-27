package Components;

import java.util.Arrays;

/**
 * This class is to specify a position in two dimensions (2D).
 * The first dimension is x, and second dimension is y.
 *
 * @author MaZeeT
 */
public class Position implements Comparable<Position> {

     int x;
     int y;

    /**
     * Stores the two given dimensions.
     *
     * @param x The x position.
     * @param y The y position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the x position.
     *
     * @return Return the x position.
     */
    public int getX() {
        return x;
    }

    /**
     * return the y position.
     *
     * @return Return the y position.
     */
    public int getY() {
        return y;
    }

    /**
     * modify the x position.
     *
     * @param x Modify the stored x position to the given x position
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * modify the y position.
     *
     * @param y Modify the stored y position to the given y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Compare the position obj with each other.
     * If one have a lower position in the x or y dimensions -1 will be returned.
     * If one have a higher position in the x or y dimensions +1 will be returned.
     * If both positions have equal x and y dimensions 0 will be returned.
     *
     * @param otherPos The other compared position.
     * @return Return -1, 0, +1 depending on if the other position is greater, equal, or lower than the original position.
     */
    @Override
    public int compareTo(Position otherPos) {
        int rtn = 0;
        if (x == otherPos.getX() && y == otherPos.getY()) {
            return 0;
        }
        if (x < otherPos.getX()) rtn = +1;
        if (x > otherPos.getX()) rtn = -1;

        if (rtn == 0) {
            if (y < otherPos.getY()) rtn = +1;
            if (y > otherPos.getY()) rtn = -1;
        }
        return rtn;
    }

    /**
     * Override the equals function, where it will check if x and y is equal to the compared x and y of the object.
     *
     * @param obj The object the Position is trying to compare to.
     * @return Returns a boolean to show if the obj is equal to the position or not.
     */
    @Override
    public boolean equals(Object obj) {
        try {
            Position other = (Position) obj;
            return (x == other.x && y == other.y);
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Calculate the hashcode of the position based on the given x and y position.
     *
     * @return Return a hashcode based on the x and y position.
     */
    @Override
    public int hashCode() {
        final int[] numbers = {x, y};
        return Arrays.hashCode(numbers);
    }

}
