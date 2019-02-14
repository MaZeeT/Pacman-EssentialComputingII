package SnakeModel;

import SnakeLogic.GameObject;

public class Player implements GameObject {

    private Position position;

    Player(Position position){
        this.position = position;
    }

    public void update() {

    }

    public Position getPosition(){
        return position;
    }
}
