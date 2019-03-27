package GUI;

import Entities.GameObject;

import java.util.List;

//TODO write javaDoc
public class Manager implements IGUI {

    private View view ;
    private Controller controller;

    public Manager(int width, int height){
        this.view = new View(width,height);
        this.controller = new Controller(this, view.btnStart, view.btnPause);
    }

    public void update(List<GameObject> gameObjects){
        view.setGameObjects(gameObjects);
        view.drawCanvas();
    }

    public void startGame() {
        view.label.setText("Playing");
        System.out.println("Start btn pressed");
    }

    public void pauseGame(){
        view.label.setText("Paused");
        System.out.println("Pause btn pressed");
    }

    public View getView(){
        return this.view;
    }
}
