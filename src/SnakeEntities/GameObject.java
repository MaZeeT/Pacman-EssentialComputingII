package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

//TODO write javaDoc
public abstract class GameObject implements Comparable<GameObject>{
    Position position;
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int compareTo(GameObject other) {
        return position.compareTo(other.getPosition());
    }
}
