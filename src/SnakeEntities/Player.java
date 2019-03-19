package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

//TODO write javaDoc
public class Player extends GameObject {

    public Player(Position position) {
        this.position = position;
        this.color = Color.BLACK;
    }

    public Position moveUp() {
        position.setY(position.getY() - 1);
        return getPosition();
    }

    public Position moveDown() {
        position.setY(position.getY() + 1);
        return getPosition();
    }

    public Position moveLeft() {
        position.setX(position.getX() - 1);
        return getPosition();
    }

    public Position moveRight() {
        position.setX(position.getX() + 1);
        return getPosition();
    }

    public Position checkUp() {
        int x = position.getX();
        int y = position.getY() - 1;
        return new Position(x, y);
    }

    public Position checkDown() {
        int x = position.getX();
        int y = position.getY() + 1;
        return new Position(x, y);
    }


    public Position checkLeft() {
        int x = position.getX() - 1;
        int y = position.getY();
        return new Position(x, y);
    }

    public Position checkRight() {
        int x = position.getX() + 1;
        int y = position.getY();
        return new Position(x, y);
    }

}
