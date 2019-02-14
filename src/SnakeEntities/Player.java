package SnakeEntities;

import SnakeComponents.GameObject;
import SnakeComponents.PlayerControl;
import SnakeComponents.Position;

public class Player implements GameObject {

    private Position position;
    private PlayerControl control;

    Player(Position position, PlayerControl control){
        this.position = position;
        this.control = control;
    }

    public void update() {

    }

    public Position getPosition(){
        return position;
    }
}
