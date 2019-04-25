package GUI.SimpleGUI;

import Entities.GameObject;
import GUI.IGUI;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to provide a graphical representation of the running program.
 * When the class can fulfill the {@link IGUI} interface it will be able to be used with the program.
 *
 * @author MaZeeT.
 */
public class SimpleGUI implements IGUI {
    private Canvas canvas = new Canvas(600.0, 400.0);
    private BorderPane pane = new BorderPane();
    private List<GameObject> gameObjects = new ArrayList<>();
    private double fieldHeight;
    private double fieldWidth;
    private int width;
    private int height;

    /**
     * Constructor to set the size of the scene and make a initial render.
     *
     * @param width  The width of the scene.
     * @param height The height of the scene.
     */
    public SimpleGUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.pane.setCenter(canvas);
        calculateFields();
        drawCanvas();
    }

    /**
     * Set the list to the given {@link GameObject}s from outside the {@link IGUI}.
     *
     * @param gameObjects The list of renderables gameObjects.
     */
    void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }


    /**
     * A helper method to calculate height and width of each field in the graphicsContext2D.
     */
    private void calculateFields() {
        this.fieldHeight = canvas.getHeight() / this.height;
        this.fieldWidth = canvas.getWidth() / this.width;
    }

    /**
     * A Method to draw the canvas with the given {@link GameObject}s.
     */
    void drawCanvas() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.clearRect(0, 0, width * fieldWidth, height * fieldHeight);

        for (GameObject gameObject : gameObjects) {
            g.setFill(gameObject.getColor());
            int x = gameObject.getPosition().getX();
            int y = gameObject.getPosition().getY();
            g.fillRoundRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight, 5, 5);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(List<GameObject> gameObjects) {
        setGameObjects(gameObjects);
        drawCanvas();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pane getPane() {
        return this.pane;
    }

}
