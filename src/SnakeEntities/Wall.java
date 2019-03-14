package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class Wall extends GameObject implements Comparable<Wall>{

    public Wall(int x, int y) {
        this.position = new Position(x, y);
        this.color = Color.GREY;
    }

    public Wall(Position position) {
        this.position = position;
        this.color = Color.GREY;
    }

    @Override
    public int compareTo(Wall other) {
        return position.compareTo(other.getPosition());
    }
}
