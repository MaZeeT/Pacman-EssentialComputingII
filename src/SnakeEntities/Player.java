package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to define a {@link GameObject} that a {@link SnakeLogic.Crawler.Crawler}
 * or a {@link SnakeUserControl.UserControl} can control.
 *
 * @author MaZeeT
 */
public class Player extends GameObject {

    /**
     * This constructor take a {@link Position} to define where the {@link Player} will be positioned.
     * @param position The {@link Position} that defines where to position the {@link Player}.
     */
    public Player(Position position) {
        this.position = position;
        this.color = Color.BLACK;
    }

    /**
     * Change the {@link Position} of the {@link Player} to one above.
     * @return Returns the new {@link Position}.
     */
    public Position moveUp() {
        position.setY(position.getY() - 1);
        return getPosition();
    }

    /**
     * Change the {@link Position} of the {@link Player} to one below.
     * @return Returns the new {@link Position}.
     */
    public Position moveDown() {
        position.setY(position.getY() + 1);
        return getPosition();
    }

    /**
     * Change the {@link Position} of the {@link Player} to the left.
     * @return Returns the new {@link Position}.
     */
    public Position moveLeft() {
        position.setX(position.getX() - 1);
        return getPosition();
    }

    /**
     * Change the {@link Position} of the {@link Player} to the right.
     * @return Returns the new {@link Position}.
     */
    public Position moveRight() {
        position.setX(position.getX() + 1);
        return getPosition();
    }

    /**
     * Make a new {@link Position} above the {@link Player}.
     * @return Returns a new {@link Position}.
     */
    public Position checkUp() {
        int x = position.getX();
        int y = position.getY() - 1;
        return new Position(x, y);
    }

    /**
     * Make a new {@link Position} below the {@link Player}.
     * @return Returns a new {@link Position}.
     */
    public Position checkDown() {
        int x = position.getX();
        int y = position.getY() + 1;
        return new Position(x, y);
    }

    /**
     * Make a new {@link Position} to the left of the {@link Player}.
     * @return Returns a new {@link Position}.
     */
    public Position checkLeft() {
        int x = position.getX() - 1;
        int y = position.getY();
        return new Position(x, y);
    }

    /**
     * Make a new {@link Position} to the right of the {@link Player}.
     * @return Returns a new {@link Position}.
     */
    public Position checkRight() {
        int x = position.getX() + 1;
        int y = position.getY();
        return new Position(x, y);
    }

}
