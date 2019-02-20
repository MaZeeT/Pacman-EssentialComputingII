package SnakeLogic.SnakeEntities;

import SnakeLogic.SnakeComponents.Position;
import javafx.scene.paint.Color;

public abstract class GameObject {

    protected Position position;
    protected Color color;


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
