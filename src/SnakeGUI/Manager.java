package SnakeGUI;

import SnakeLogic.SnakeEntities.GameObject;

import java.util.ArrayList;

public class Manager implements IManager {

    private View view = new View();
    private Controller controller = new Controller(view);

    private ArrayList<GameObject> items;

    public void startGame() {

    }

    public void update(){

    }

    private boolean gamePaused = false;
    public void pauseGame(){
        gamePaused = !gamePaused;
    }

    public ArrayList<GameObject> getGameObjects(){
        return items;
    }

    public View getView(){
        return this.view;
    }




}
