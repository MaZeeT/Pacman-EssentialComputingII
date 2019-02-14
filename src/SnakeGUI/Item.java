package SnakeGUI;

import SnakeModel.Position;
import javafx.scene.paint.Color;

/**
 * Created by Ebbe Vang on 19-01-2017.
 */
public class Item {
    private Color Color;
    private Position position;


    public Item(Color color, Position position) {
        Color = color;
        this.position = position;

    }

    public Color getColor() {
        return Color;
    }

    public Position getPosition() {
        return position;
    }


}
