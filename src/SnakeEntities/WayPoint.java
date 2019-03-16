package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class WayPoint extends GameObject {

    public WayPoint(Position position) {
        this.position = position;
        this.color = Color.YELLOW;
    }
}
