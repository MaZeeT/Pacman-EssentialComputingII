package SnakeLogic;

import SnakeComponents.PlayerControl;
import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Item;
import SnakeEntities.Player;
import SnakeGUI.View;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

import java.util.*;

public class GameManager{

    private View view;
    private ArrayList<GameObject> items = new ArrayList<>();
    private PlayerControl pc = new PlayerControl();


    public GameManager(View view) {
        this.view = view;
        AddItems();
        view.setItemsToRender(items);
    }

    public Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(view.width);
        int y = random.nextInt(view.height);
        return new Position(x, y);
    }

    private void AddItems() {
        items.add(new Item(Color.GREEN, getRandomPosition()));
        items.add(new Item(Color.RED, getRandomPosition()));
    }


    private int gameLoopDelay = 500;
    private float refreshRate = 300;

    /**
     * Executed when JavaFX is initialized. Used to setup the Snake game
     */
    public void initialize() {
        view.calculateFields();
        view.drawCanvas();

        // Start and control game loop
        new AnimationTimer() {
            long lastUpdate;

            public void handle(long now) {
                if (now > lastUpdate + refreshRate * 1000000) {
                    lastUpdate = now;
                    pc.update(now);
                }
            }
        }.start();
    }
}
