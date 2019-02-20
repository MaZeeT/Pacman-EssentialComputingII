package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public abstract class GameObject {

    Position position;
    Color color;


    protected abstract void update();

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

}
