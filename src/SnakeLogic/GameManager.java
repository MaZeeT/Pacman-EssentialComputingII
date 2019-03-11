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
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<GameObject> items = new ArrayList<>();
    private List<GameObject> walls;
    private List<GameObject> players = new ArrayList<>();

    private Player player = new Player(new Position(4, 5));

    private int amountItems = 0;
    private int maxItems = 2;


    char direction;


    public GameManager(View view) {
        this.view = view;
        addNewItem(amountItems, maxItems);
        players.add(player);
        maze = new Maze(10, 10);
        maze.generateMaze();
        walls = maze.getMaze();

    }

    public void update() {
        addNewItem(amountItems, maxItems);
        movement(direction, player);
        //player.
        updateRenderables();
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

    private void updateRenderables() {
        gameObjects.clear();
        gameObjects.addAll(items);
        gameObjects.addAll(walls);
        gameObjects.addAll(players);
    }

    private void addNewItem(int amountItems, int maxItems) {
        if (amountItems < maxItems) {
            items.add(new Item(getRandomPosition()));
            this.amountItems++;
        }
    }

    private void removeItem(int index) {
        items.remove(index);
    }

    private Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(view.width);
        int y = random.nextInt(view.height);
        return new Position(x, y);
    }

    private void collideWithItem(Item item) {

    }

    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;

    }
}
