package GUI;

import Entities.GameObject;

import java.util.List;

//TODO write javaDoc
public interface IGUI {

    void startGame();

    void pauseGame();

    void update(List<GameObject> gameObjects);

    View getView();
}
