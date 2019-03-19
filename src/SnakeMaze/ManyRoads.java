package SnakeMaze;

//TODO write javaDoc
public class ManyRoads extends MazeArrayBased {

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
