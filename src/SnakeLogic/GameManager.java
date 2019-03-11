package SnakeLogic;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Item;
import SnakeEntities.Player;
import SnakeGUI.View;
import SnakeMaze.Maze;

import java.util.*;

public class GameManager {

    private View view;
    private Maze maze;
    private List<GameObject> items = new ArrayList<>();
    private List<GameObject> walls;
    private List<GameObject> snake = new ArrayList<>();

    private Player player = new Player(new Position(4, 2));

    private int amountItems = 0;
    private int maxItems = 0;


    char direction;


    public GameManager(View view) {
        this.view = view;
        addNewItem(items, maxItems);
        snake.add(player);
        maze = new Maze(10, 10);
        maze.generateMaze();
        walls = maze.getMaze();

    }

    public void update() {
        //addNewItem(items, maxItems);
        movement(direction, player);
        System.out.println(player.getPosition().getX() + " " + player.getPosition().getY());

    }

    private void movement(char dir, Player player) {
        switch (dir) {
            case 'w':
                player.moveUp();
                System.out.println("up");
                break;
            case 's':
                player.moveDown();
                break;
            case 'a':
                player.moveLeft();
                break;
            case 'd':
                player.moveRight();
                break;
        }

    }


    private void addNewItem(List<GameObject> items, int maxItems) {
        if (items.size() < maxItems) {
            Position pos;
            pos = getRandomPosition();
            for (GameObject item : items) {
                if (item.getPosition().compareTo(pos) != 0) {
                    items.add(new Item(pos));
                }
            }
        }
    }


    // unused functions
    private void removeItem(int index) {
        items.remove(index);
    }

    private void collideWithItem(Item item) {

    }


    // get and set
    private Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(view.width);
        int y = random.nextInt(view.height);
        return new Position(x, y);
    }

    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }


    //export gameObjects for GUI
    private List<GameObject> combineGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(items);
        gameObjects.addAll(walls);
        gameObjects.addAll(snake);
        return gameObjects;
    }

    public List<GameObject> getGameObjects() {
        return combineGameObjects();
    }
}
