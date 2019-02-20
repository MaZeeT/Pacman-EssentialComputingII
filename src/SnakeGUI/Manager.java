package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.ArrayList;

public class Manager implements IManager {

    private View view = new View();
    private Controller controller = new Controller(view);

    public void startGame() {

    }

    public void update(){

    }

    private boolean gamePaused = false;
    public void pauseGame(){
        gamePaused = !gamePaused;
    }

    public void setGameObects(ArrayList<GameObject> gameObjects){
        view.setItemsToRender(gameObjects);
    }

    public View getView(){
        return this.view;
    }




}
