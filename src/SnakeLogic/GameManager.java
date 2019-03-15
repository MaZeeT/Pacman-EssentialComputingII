package SnakeLogic;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Item;
import SnakeEntities.Player;
import SnakeLogic.Movement.MoveClockWise;
import SnakeMaze.IMaze;
import SnakeMaze.Maze;

import java.util.*;

public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> items = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();

    private int maxItems = 2;
    private char direction;
    private int width;
    private int height;
    private MoveClockWise movement;

    public GameManager(int width, int height) {
        this.width = width;
        this.height = height;

        Player player = new Player(new Position(5, 3));
        snake.add(player);

        addNewItem(items, maxItems);

        IMaze maze = new Maze(10, 10);
        maze.generateMaze();
        walls = maze.getMaze();

        movement = new MoveClockWise(player, walls);
    }

    // update loop to make the game run
    void update() {
        movement.move(direction);
        direction = movement.getDirection();
        addNewItem(items, maxItems);
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

/*
    // unused functions
    private void removeItem(int index) {
        items.remove(index);
    }

    private void collideWithItem(Item item) {

    }
*/

    // get and set
    private Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return new Position(x, y);
    }

    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    char getDirection() {
        return this.direction;
    }

    //export gameObjects for GUI
    private List<GameObject> combineGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(items);
        gameObjects.addAll(walls);
        gameObjects.addAll(snake);
        return gameObjects;
    }

    List<GameObject> getGameObjects() {
        return combineGameObjects();
    }

}
