package SnakeLogic;

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
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private GameObject player = new Player(new Position(4,5));
    private int amountItems = 0;
    private int maxItems = 2;



    char direction;


    public GameManager(View view) {
        this.view = view;
        addNewItem(amountItems, maxItems);
        gameObjects.add(player);
    }

    public void update(){
        addNewItem(amountItems,maxItems);
    }

    private void addNewItem(int amountItems, int maxItems){
        if (amountItems < maxItems) {
            gameObjects.add(new Item(getRandomColor(),getRandomPosition()));
            this.amountItems++;
        }

    }

    private void removeItem(int index){
        gameObjects.remove(index);
    }

    private Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(view.width);
        int y = random.nextInt(view.height);
        return new Position(x, y);
    }

    private Color getRandomColor(){
        Random random = new Random();
        return Color.GREEN;
    }

    private void collideWithItem(Item item){

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
                }
            }
        }.start();
    }

    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
