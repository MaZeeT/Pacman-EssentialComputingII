package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.List;

public class Manager implements IManager {

    private View view = new View();
    private Controller controller = new Controller(this, view.btnStart, view.btnPause);

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
