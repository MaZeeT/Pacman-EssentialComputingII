package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class Item extends GameObject {

    public Item(Position position) {
        this.position = position;
        this.color = Color.RED;
    }

    public boolean update() {
        return false;
    }
}
