package GUI;

import Entities.GameObject;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to handle the output of the GUI. It will render to the scene which is passed to the primanyStage.
 * @author MaZeeT.
 */
public class View {

    Button btnStart = new Button("Start");
    Button btnPause = new Button("Pause");
    Label label = new Label("Begin");
    private HBox hBox = new HBox();
    private Canvas canvas = new Canvas(600.0, 400.0);
    public BorderPane pane = new BorderPane();

    private List<GameObject> gameObjects = new ArrayList<>();

    private double fieldHeight;
    private double fieldWidth;
    private int width;
    private int height;

    /**
     * Constructor to set the size of the scene and make a initial render.
     * @param width The width of the scene.
     * @param height The height of the scene.
     */
    View(int width, int height) {
        this.width = width;
        this.height = height;
        hBox.getChildren().addAll(btnStart, btnPause, label);
        pane.setTop(hBox);
        pane.setCenter(canvas);
        calculateFields();
        drawCanvas();
    }

    /**
     * Set the list to the gameObject list coming from outside the GUI.
     * @param gameObjects The list of renderables gameObjects.
     */
    void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }



    /**
     * Calculate height and width of each field.
     */
    private void calculateFields() {
        this.fieldHeight = canvas.getHeight() / this.height;
        this.fieldWidth = canvas.getWidth() / this.width;
    }

    /**
     * Draw the canvas.
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
}
