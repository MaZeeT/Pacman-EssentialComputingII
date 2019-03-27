package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to make a {@link GameObject} that just have to block a possible path.
 * The wall is set to a specific color.
 *
 * @author MaZeeT
 */
public class Wall extends GameObject {

    /**
     * A constructor that take two ints to define the {@link Position} where the wall should be placed.
     *
     * @param x The x dimension of the {@link Position}
     * @param y The y dimension of the {@link Position}
     */
    public Wall(int x, int y) {
        this.position = new Position(x, y);
        this.color = Color.GREY;
    }

    /**
     * A constructor that take a {@link Position} to define where the wall should be placed.
     *
     * @param position The {@link Position} that defines where the wall are placed.
     */
    public Wall(Position position) {
        this.position = position;
        this.color = Color.GREY;
    }

}
