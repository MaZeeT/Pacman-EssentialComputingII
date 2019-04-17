package Entities;

import Components.Position;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to define a {@link GameObject} that can a player can control.
 *
 * @author MaZeeT
 */
public class Player extends MovableEntity {

    /**
     * This constructor take a {@link Position} to define where the {@link Player} will be positioned.
     * @param position The {@link Position} that defines where to position the {@link Player}.
     */
    public Player(Position position) {
        this.position = position;
        this.color = Color.BLACK;
    }

}
