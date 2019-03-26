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
 * The purpose of this class is to be enable the {@link Player} to crawl around in a given {@link SnakeMaze.Maze}.
 * This is done by storing each possible steps in a data structure and make a decision about which step to take next.
 * This {@link Crawler} works with dataStructures that implements the {@link IDataStructure} interface.
 * The {@link SnakeDataStructures.DepthFirst} dataStructure will give a depth first approach.
 * The {@link SnakeDataStructures.BreadthFirst} dataStructure will give a Breadth first approach.
 * //TODO add the greedy dataStructure.
 *
 * @author MaZeeT
 */
public class Crawler {

    private Player player;
    private List<GameObject> gameObjects;
    private List<Position> gameObjectPositions;
    private IDataStructure dataStructure;

    /**
     * The constructor of the {@link Crawler} class,
     * This take a {@link SnakeMaze.Maze} and a dataStructure as an input,
     * and links some of the objects inside the {@link SnakeMaze.Maze} to some of the private variables of this class.
     *
     * @param maze          The {@link SnakeMaze.Maze} where the {@link Crawler} will move in.
     * @param dataStructure The dataStructure that will hold the {@link Position}s the {@link Crawler} will move to.
     */
    public Crawler(IMaze maze, IDataStructure dataStructure) {
        this.player = maze.getPlayer();
        this.gameObjects = maze.getMaze();
        this.gameObjectPositions = maze.getMazePositions();
        this.dataStructure = dataStructure;
    }

    /**
     * This function is called on each update "tick".
     * First the {@link Position} of the {@link Player} is added as a visited wall,
     * and nearby positions of the {@link Player} is checked and added to the dataStructure.
     * If the dataStructure is not empty, the {@link Player}'s position will be checked to the next in the dataStructure.
     */
    public void update() {
        gameObjects.add(visited(player.getPosition()));
        checkNearby(player);
        if (dataStructure.checkNext() != null) {

            player.setPosition(dataStructure.getNext());
        }
    }

    /**
     * Instantiate a new {@link Wall} object, set the color to YELLOW and return the new {@link Wall} object.
     *
     * @param position The {@link Position} of the new instantiated {@link Wall}.
     * @return Return a new YELLOW {@link Wall} object
     */
    private Wall visited(Position position) {
        Wall wall = new Wall(position);
        wall.setColor(Color.YELLOW);
        return wall;
    }

    /**
     * Check all the {@link Position} around the player, and call the "addToDataStructure" on each {@link Position}.
     *
     * @param player The crawling {@link Player}.
     */
    private void checkNearby(Player player) {
        addToDataStructure(player.checkUp());
        addToDataStructure(player.checkLeft());
        addToDataStructure(player.checkDown());
        addToDataStructure(player.checkRight());

    }

    /**
     * Checks if a given {@link Position} is in the list of gameObjectPositions, and adds the {@link Position} if not.
     *
     * @param position The {@link Position} that will be added to the gameObjectPosition list.
     */
    private void addToDataStructure(Position position) {
        if (!gameObjectPositions.contains(position))
            dataStructure.add(position);
    }

}
