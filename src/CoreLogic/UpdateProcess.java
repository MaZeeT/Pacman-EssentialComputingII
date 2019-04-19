package CoreLogic;

import GUI.IGUI;

/**
 * The purpose of this class is to make a thread to handle all the update calls the program need.
 * The update in {@link GameManager} needs to be called to change the positions of the elements in the game logic wise,
 * and the update in {@link IGUI} needs to be called to render the new positions to the scene.
 *
 * @author MaZeeT
 */
public class UpdateProcess extends Thread {
    private GameManager gameManager;
    private IGUI gui;
    private int speed;

    /**
     * The constructor for this class. The class need to know about the {@link GameManager} and the {@link IGUI} to call the update functions in each.
     * Lastly the class need to know how long the delay between each updates has to be.
     *
     * @param gameManager The {@link GameManager}.
     * @param gui The {@link IGUI}.
     * @param speed The delay between each updates in milliseconds.
     */
    UpdateProcess(GameManager gameManager, IGUI gui, int speed) {
        this.gameManager = gameManager;
        this.gui = gui;
        this.speed = speed;
    }

    /**
     * The logic the this thread runs
     */
    @Override
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
