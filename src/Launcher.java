import SnakeDataStructures.BreadthFirst;
import SnakeDataStructures.DepthFirst;
import SnakeDataStructures.Greedy;
import SnakeDataStructures.IDataStructure;
import SnakeGUI.IGUI;
import SnakeGUI.Manager;
import SnakeLogic.GameManager;
import SnakeMaze.*;
import SnakeUserControl.PlayerControl;
import SnakeUserControl.UserControl;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * The purpose of this class is to combine the different elements the program consist of.
 * The combined elements are the {@link GameManager}, the {@link UserControl} interface and the {@link IGUI} interface.
 * Lastly this class provide the Stage with the scene from the program.
 *
 * @author MaZeeT
 */
public class Launcher {
    private Scene scene;
    private IMaze maze;
    private IDataStructure dataStructure;

    //TODO finish javaDoc for constructor

    /**
     * Instantiate the different elements of the program and starts the thread that updates the program based on runSpeed.
     *
     * @param width    placeholder //TODO replace
     * @param height   placeholder //TODO replace
     * @param runSpeed The time in milliseconds between each call to update in {@link UpdateProcess}.
     */
    Launcher(int width, int height, int runSpeed) {
        // Interfaced modules
        IGUI gui = new Manager(width, height);
        UserControl userControl = new PlayerControl();

        // Options for setting maze.
        // 0 for MazeObj.
        // 1 for MazeWithExit.
        // 2 for ManyRoads.
        // 3 for ForkRoad.
        maze = setMaze(3);

        // Options for setting dataStructure.
        // 0 for DepthFirst.
        // 1 for BreadthFirst.
        // 2 for Greedy.
        dataStructure = setDataStructure(0);

        // Game logic
        GameManager gameManager = new GameManager(maze, dataStructure);

        // Setup scene and stage
        this.scene = setupScene(gui.getView().pane, userControl, gameManager);

        // Update thread
        UpdateProcess updateProcess = new UpdateProcess(gameManager, gui, runSpeed);
        updateProcess.start();
    }

    /**
     * Setup a scene with a pane from the {@link IGUI} and bridges the {@link UserControl} with the direction in the {@link GameManager}.
     *
     * @param pane        The given pane that will render the objects of the {@link GameManager}.
     * @param userControl The {@link UserControl} for the program.
     * @param gameManager The {@link GameManager} for the program.
     * @return Returns a new Scene based on the given pane.
     */
    private Scene setupScene(Pane pane, UserControl userControl, GameManager gameManager) {
        Scene scene = new Scene(pane, 800, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.getDirection(event.getCode());
                gameManager.setDirection(userControl.getDirection(event.getCode()));
            }
        });
        return scene;
    }

    /**
     * Returns the scene.
     *
     * @return Returns the scene.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * This method make it possible to select the wanted maze by using an int as parameter.
     *
     * @param index The index of a given maze.
     *              0 for MazeObj.
     *              1 for MazeWithExit.
     *              2 for ManyRoads.
     *              3 for ForkRoad.
     * @return Returns the selected maze.
     */
    private IMaze setMaze(int index) {
        if (index == 0) return new MazeObj(10, 10);
        if (index == 1) return new MazeWithExit();
        if (index == 2) return new ManyRoads();
        if (index == 3) return new ForkRoad();

        //Default
        return new ManyRoads();
    }

    /**
     * This method make it possible to select the wanted dataStructure by using an int as parameter.
     *
     * @param index The index of a given dataStructure.
     *              0 for DepthFirst.
     *              1 for BreadthFirst.
     *              2 for Greedy.
     * @return Returns the selected dataStructure.
     */
    private IDataStructure setDataStructure(int index) {
        if (index == 0) return new DepthFirst();
        if (index == 1) return new BreadthFirst();
        if (index == 2) return new Greedy(this.maze.getWayPoint().getPosition());

        //Default
        return new DepthFirst();
    }
}
