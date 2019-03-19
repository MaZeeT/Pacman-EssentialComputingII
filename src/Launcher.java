import SnakeGUI.IGUI;
import SnakeGUI.Manager;
import SnakeLogic.GameManager;
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

    //TODO finish javaDoc for constructor

    /**
     * Instantiate the different elements of the program and starts the thread that updates the program based on runSpeed.
     *
     * @param width placeholder //TODO replace
     * @param height placeholder //TODO replace
     * @param runSpeed The time in milliseconds between each call to update in {@link UpdateProcess}.
     */
    Launcher(int width, int height, int runSpeed) {
        // Interfaced modules
        IGUI gui = new Manager(width, height);
        UserControl userControl = new PlayerControl();

        // Game logic
        GameManager gameManager = new GameManager(width, height);

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
}
