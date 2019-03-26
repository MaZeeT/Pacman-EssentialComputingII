package SnakeLogic.Crawler;

import SnakeComponents.Position;
import SnakeDataStructures.IDataStructure;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeMaze.IMaze;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * The purpose of this class is to be enable the player to crawl around in a given maze.
 * This is done by storing each possible steps in a data structure and make a decision about which step to take next.
 * This crawler works with dataStructures that implements the {@link IDataStructure} interface.
 * The {@link SnakeDataStructures.DepthFirst} dataStructure will give a depth first approach.
 * The {@link SnakeDataStructures.BreadthFirst} dataStructure will give a Breadth first approach.
 *
 * @author MaZeeT
 */
public class Crawler {

    private Player player;
    private List<GameObject> gameObjects;
    private List<Position> gameObjectPositions;
    private IDataStructure dataStructure;

    /**
     * The constructor of the Crawler class,
     * This take a maze and a dataStructure as an input, and links some of the objects inside the maze to some of the private variables of this class.
     *
     * @param maze          The maze where the crawler will move in.
     * @param dataStructure The dataStructure that will hold the positions the crawler will travel thought.
     */
    public Crawler(IMaze maze, IDataStructure dataStructure) {
        this.player = maze.getPlayer();
        this.gameObjects = maze.getMaze();
        this.gameObjectPositions = maze.getMazePositions();
        this.dataStructure = dataStructure;
    }

    /**
     * This function is called on each update "tick".
     * First the location of the player is added as a visited wall,
     * and nearby positions of the player is checked and added to the dataStructure.
     * If the dataStructure is not empty, the players position will be checked to the next in the dataStructure.
     */
    public void update() {
        gameObjects.add(visited(player.getPosition()));
        checkNearby(player);
        if (dataStructure.checkNext() != null) {

            player.setPosition(dataStructure.getNext());
        }
    }

    /**
     * Instantiate a new Wall object, set the color to YELLOW and return the new Wall object.
     *
     * @param position The position the new wall need to be instantiated at.
     * @return Return a new YELLOW Wall object
     */
    private Wall visited(Position position) {
        Wall wall = new Wall(position);
        wall.setColor(Color.YELLOW);
        return wall;
    }

    /**
     * Check all the positions around the player, and call the "addNearby" on each position.
     *
     * @param player The player that need to check nearby positions.
     */
    private void checkNearby(Player player) {
        addNearby(player.checkUp());
        addNearby(player.checkLeft());
        addNearby(player.checkDown());
        addNearby(player.checkRight());
    }

    /**
     * Checks if a given position is in the list of gameObjectPositions, and adds it if thegiven position isn't included.
     *
     * @param position A given position that need to be added to the list of positions.
     */
    private void addNearby(Position position) {
        for (Position pos : gameObjectPositions) {
            if (pos.compareTo(position) == 0) return;
        }
        if (!dataStructure.contains(position)) {
            dataStructure.add(position);
        }
    }

}
