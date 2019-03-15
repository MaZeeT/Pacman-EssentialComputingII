import SnakeGUI.IManager;
import SnakeGUI.Manager;
import SnakeLogic.GameManager;
import SnakeLogic.UpdateProcess;
import SnakeUserControl.PlayerControl;
import SnakeUserControl.UserControl;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Launcher {
    private Scene scene;
    private GameManager gameManager;
    private UserControl userControl;
    private IManager gui;

    public Launcher(int width, int height, int runSpeed) {
        // Interfaced modules
        gui = new Manager(width, height);
        userControl = new PlayerControl();

        // Game logic
        gameManager = new GameManager(width, height);

        // Setup scene and stage
        this.scene = setupScene();

        // Update thread
        UpdateProcess updateProcess = new UpdateProcess(gameManager, gui, runSpeed);
        updateProcess.start();
    }

    private Scene setupScene() {
        Scene scene = new Scene(gui.getView().pane, 800, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.getDirection(event.getCode());
                gameManager.setDirection(userControl.getDirection(event.getCode()));
            }
        });
        return scene;
    }

    public Scene getScene() {
        return scene;
    }
}
