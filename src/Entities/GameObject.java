package Entities;

import Components.Position;
import javafx.scene.paint.Color;

import java.util.Arrays;

/**
 * The purpose of this class is to define some common features of the different classes that extend this abstract class.
 *
 * @author MaZeeT
 */
public abstract class GameObject implements Comparable<GameObject> {
    Position position;
    Color color;

    /**
     * Get the color of the {@link GameObject}.
     *
     * @return Returns the color of the {@link GameObject}.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the color of the {@link GameObject}.
     *
     * @param color The color the {@link GameObject} have to be.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get the {@link Position} of the {@link GameObject}.
     *
     * @return Return the {@link Position} of the {@link GameObject}.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the {@link Position} of the {@link GameObject}.
     *
     * @param position Takes a {@link Position}.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Overrides the compareTo method from the Comparable interface.
     *
     * @param other The other {@link GameObject} that need to be compared.
     * @return Returns -1,0,+1 depending on if the other {@link GameObject}
     * is smaller, equal or greater than the {@link GameObject} that this method is invoked on.
     */
    @Override
    public int compareTo(GameObject other) {
        return position.compareTo(other.getPosition());
    }

    /**
     * Override the equals function, where it will check if {@link Position} and color is equal to the compared {@link Position} and color of the object.
     *
     * @param obj The object the {@link GameObject} is trying to compare to.
     * @return Returns a boolean to show if the obj is equal to the {@link GameObject} or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameObject) {
            GameObject other = (GameObject) obj;
            return (position.equals(other.position) && color == other.color);
        } else {
            return false;
        }
    }

    /**
     * Calculate the hashcode of the {@link GameObject} based on the given position and color.
     *
     * @return Return a hashcode based on the x, y and distance variables.
     */
    @Override
    public int hashCode() {
        final Object[] objects = {position, color};
        return Arrays.hashCode(objects);
    }

}
