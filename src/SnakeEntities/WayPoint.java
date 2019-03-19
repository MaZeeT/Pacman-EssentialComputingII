package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

//TODO write javaDoc
public class WayPoint extends GameObject {

    public WayPoint(Position position) {
        this.position = position;
        this.color = Color.GREEN;
    }
}
