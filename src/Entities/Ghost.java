package Entities;

import Components.Position;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to define a {@link GameObject} that a {@link Logic.Crawler.Crawler}
 * can control.
 *
 * @author MaZeeT
 */
public class Ghost extends MovableEntity {

    /**
     * This constructor take a {@link Position} to define the starting position of the{@link Ghost}, with a default color of RED.
     *
     * @param position The {@link Position} that defines where to position the {@link Ghost}.
     */
    public Ghost(Position position) {
        this.position = position;
        this.color = Color.RED;
    }

    /**
     * This constructor take a {@link Position} to define the starting position, and a Color to define the color if the {@link Ghost}.
     *
     * @param position The {@link Position} that defines where to position the {@link Ghost}.
     * @param color    The color the {@link Ghost} will have.
     */
    public Ghost(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

}
