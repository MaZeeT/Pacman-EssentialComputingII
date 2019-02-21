package SnakeGUI;

import SnakeEntities.GameObject;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class View {

    Button btnStart = new Button("start");
    private Label labelStatus = new Label("Label");
    private HBox hBox = new HBox();
    private Canvas canvas = new Canvas(600.0, 400.0);
    public BorderPane pane = new BorderPane();

    private List<GameObject> renderableGameObjects = new ArrayList<>();

    View() {
        hBox.getChildren().addAll(btnStart, labelStatus);
        pane.setTop(hBox);
        pane.setCenter(canvas);
        calculateFields();
        drawCanvas();
    }

    public void setItemsToRender(List<GameObject> gameObjects) {
        this.renderableGameObjects = gameObjects;
    }


    private double fieldHeight;
    private double fieldWidth;
    public int width = 30;
    public int height = 20;


    /**
     * Calculate height and width of each field
     */
    public void calculateFields() {
        this.fieldHeight = canvas.getHeight() / this.height;
        this.fieldWidth = canvas.getWidth() / this.width;
    }

    /**
     * Draw the canvas - used in the gameloop
     */
    public void drawCanvas() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        g.clearRect(0, 0, width * fieldWidth, height * fieldHeight);

        // draw renderableGameObjects
        for (GameObject gameObject : renderableGameObjects) {
            g.setFill(gameObject.getColor());
            int x = gameObject.getPosition().getX();
            int y = gameObject.getPosition().getY();
            g.fillRoundRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight, 5, 5);
        }
    }
}
