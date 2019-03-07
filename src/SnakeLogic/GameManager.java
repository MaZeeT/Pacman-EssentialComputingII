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
    private Maze maze;
    private List<GameObject> renderableGameObjects = new ArrayList<>();
    private List<GameObject> items = new ArrayList<>();
    private List<GameObject> walls;
    private List<GameObject> players = new ArrayList<>();

    private GameObject player = new Player(new Position(4,5));
    private int amountItems = 0;
    private int maxItems = 2;



    char direction;


    public GameManager(View view) {
        this.view = view;
        addNewItem(amountItems, maxItems);
        players.add(player);
        maze = new Maze(2,7);
        walls = maze.getMaze();
    }

    public void update(){
        addNewItem(amountItems,maxItems);
        //player.
        updateRenderables();
    }

    private void updateRenderables(){
        renderableGameObjects.clear();
        renderableGameObjects.addAll(items);
        renderableGameObjects.addAll(walls);
        renderableGameObjects.addAll(players);
    }

    private void addNewItem(int amountItems, int maxItems){
        if (amountItems < maxItems) {
            items.add(new Item(getRandomColor(),getRandomPosition()));
            this.amountItems++;
        }

    }

    private void removeItem(int index){
        items.remove(index);
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

    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    public List<GameObject> getRenderableGameObjects(){
        return renderableGameObjects;
    }
}
