package Maze;

/**
 * The purpose of this class is to provide a default maze to instantiate the direct super test with.
 * By instantiating this class your are able to run tests against the superclass.
 *
 * @author MaZeeT
 */
class MazeArrayTestable extends MazeArrayBased {

    /**
     * Define a sizes for the super class loops.
     *
     * @param width  The width of the maze.
     * @param height The height of the maze.
     */
    MazeArrayTestable(int width, int height) {
        super(width, height);
    }

}
