package SnakeLogic;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Item;
import SnakeEntities.Player;
import SnakeGUI.View;
import SnakeMaze.IMaze;
import SnakeMaze.Maze;

import java.util.*;

public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> items = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();
    private Player player = new Player(new Position(4, 2));

    private int maxItems = 2;
    private char direction;
    private int width;
    private int height;

    public GameManager(View view) {
        width = view.width;
        height = view.height;
        addNewItem(items, maxItems);
        snake.add(player);
        IMaze maze = new Maze(10, 10);
        maze.generateMaze();
        walls = maze.getMaze();
    }


    public void update() {
        movement(direction, player);
        System.out.println(player.getPosition().getX() + " " + player.getPosition().getY());
        addNewItem(items, maxItems);
    }

    private void movement(char dir, Player player) {
        switch (dir) {
            case 'w':
                if (!isPositionInList(walls, player.checkUp())) player.moveUp();
                else {
                    System.out.println("Path Blocked");
                    setDirection('d');
                    update();
                }
                break;

            case 's':
                if (!isPositionInList(walls, player.checkDown())) player.moveDown();
                else {
                    System.out.println("Path Blocked");
                    setDirection('a');
                    update();
                }
                break;

            case 'a':
                if (!isPositionInList(walls, player.checkLeft())) player.moveLeft();
                else {
                    System.out.println("Path Blocked");
                    setDirection('w');
                    update();
                }
                break;

            case 'd':
                if (!isPositionInList(walls, player.checkRight())) player.moveRight();
                else {
                    System.out.println("Path Blocked");
                    setDirection('s');
                    update();
                }
                break;
        }
    }

    private boolean isPositionInList(List<GameObject> gameObjects, Position position) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getPosition().compareTo(position) == 0) {
                return true;
            }
        }
        return false;
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
        int x = random.nextInt(width);
        int y = random.nextInt(height);
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
