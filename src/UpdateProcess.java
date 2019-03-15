import SnakeGUI.IManager;
import SnakeLogic.GameManager;

public class UpdateProcess extends Thread {
    private GameManager gameManager;
    private IManager gui;
    private int speed;

    UpdateProcess(GameManager gameManager, IManager gui, int speed) {
        this.gameManager = gameManager;
        this.gui = gui;
        this.speed = speed;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                gameManager.update();
                gui.update(gameManager.getGameObjects());
                sleep(speed);
            } catch (Exception e) {
                isRunning = false;
            }
        }
    }
}
