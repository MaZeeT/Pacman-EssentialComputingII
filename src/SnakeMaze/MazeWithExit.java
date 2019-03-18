package SnakeMaze;

public class MazeWithExit extends MazeArrayBased{


    public MazeWithExit(int width, int height) {
        super(width,height);

        //MazeArrayBased arrayGet = new MazeArrayBased(6,7);
        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 2, 1, 0, 0, 3},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };
        walls = walls(maze);
        player = player(maze);
        wayPoint = wayPoint(maze);
    }

    @Override
    public void generateMaze() {
    }

}
