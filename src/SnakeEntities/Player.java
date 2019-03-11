package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class Player extends GameObject {

    public Player(Position position) {
        this.position = position;
        this.color = Color.BLACK;
    }

    public boolean update() {
        return false;
    }

    public Position moveUp() {
        position.setY(position.getY() - 1);
        return getPosition();
    }

    public Position moveDown() {
        position.setY(position.getY() + 1);
        return position;
    }

    public Position moveLeft() {
        position.setX(position.getX() - 1);
        return getPosition();
    }

    public Position moveRight() {
        position.setX(position.getX() + 1);
        return getPosition();
    }

}
