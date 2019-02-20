package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class Player extends GameObject {

    public Player(Position position) {
        this.position = position;
        color = Color.BLACK;
    }

    public void update() {

    }
}
