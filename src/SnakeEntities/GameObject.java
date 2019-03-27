package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

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
     * Overrides the compareTo method from the Comparable interface, and reuse the compareTo method from the {@link Position} class.
     *
     * @param other The other {@link GameObject} that need to be compared.
     * @return Returns -1,0,+1 depending on if the other {@link GameObject}
     * is smaller, equal or greater than the {@link GameObject} that this method is invoked on.
     */
    @Override
    public int compareTo(GameObject other) {
        return position.compareTo(other.getPosition());
    }

}
