package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

public class Wall extends GameObject {

    public Wall(int x, int y){
        this.position = new Position(x,y);
        this.color = Color.GREY;
    }

    @Override
    protected void update() {

    }
}
