package Maze;

/**
 * The purpose of this class is to add a new maze with a fork of paths between the {@link Entities.Player} and {@link Entities.WayPoint},
 * but only 1 valid path.
 *
 * @author MaZeeT
 */
public class ForkRoad2 extends MazeArrayBased {

    /**
     * This constructor contains an 2D array to symbolize a maze.
     * The methods from {@link MazeArrayBased} are used to convert the array to different {@link Entities.GameObject}s.
     */
    public ForkRoad2() {
        super();
        this.width = 10;
        this.height = 10;

        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 3},
                {1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        walls = walls(maze);
        player = player(maze);
        wayPoint = wayPoint(maze);
    }

}
