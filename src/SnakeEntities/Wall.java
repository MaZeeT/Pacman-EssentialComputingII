package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

//TODO write javaDoc
public class Wall extends GameObject{

    public Wall(int x, int y) {
        this.position = new Position(x, y);
        this.color = Color.GREY;
    }

    public Wall(Position position) {
        this.position = position;
        this.color = Color.GREY;
    }


}
