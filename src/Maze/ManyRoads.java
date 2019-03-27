package Maze;

/**
 * The purpose of this class is to add a new maze with multiple valid paths between the {@link Entities.Player} and {@link Entities.WayPoint}.
 *
 * @author MaZeeT
 */
public class ManyRoads extends MazeArrayBased {

    /**
     * This constructor contains an 2D array to symbolize a maze.
     * The methods from {@link MazeArrayBased} are used to convert the array to different {@link Entities.GameObject}s.
     */
    public ManyRoads() {
        super();
        this.width = 10;
        this.height = 10;

        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 3},
                {1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        walls = walls(maze);
        player = player(maze);
        wayPoint = wayPoint(maze);
    }

}
