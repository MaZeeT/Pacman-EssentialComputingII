package SnakeEntities;

import SnakeComponents.GameObject;
import SnakeComponents.Position;
import javafx.scene.paint.Color;

/**
 * Created by Ebbe Vang on 19-01-2017.
 */
public class Item implements GameObject {
    private Color Color;
    private Position position;


    public Item(Color color, Position position) {
        Color = color;
        this.position = position;
    }

    public void update() {

    }

    public Color getColor() {
        return Color;
    }

    public Position getPosition() {
        return position;
    }


}
