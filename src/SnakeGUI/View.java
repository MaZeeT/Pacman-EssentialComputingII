package SnakeGUI;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class View {

    protected Button btnStart = new Button("start");
    Label labelStatus = new Label("Label");
    HBox hBox = new HBox();
    Canvas canvas = new Canvas(600.0, 400.0);
    public BorderPane pane = new BorderPane();

    private ArrayList<GameObject> items = new ArrayList<>();
    private Player player;

    public View() {
        hBox.getChildren().addAll(btnStart, labelStatus);
        pane.setTop(hBox);
        pane.setCenter(canvas);
        calculateFields();
        drawCanvas();
    }

    public void setPlayer(Player player){this.player = player;}

    public void setItemsToRender(ArrayList<GameObject> items){
        this.items = items;
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

        // draw items
        for (GameObject item : items) {
            g.setFill(item.getColor());
            int x = item.getPosition().getX();
            int y = item.getPosition().getY();
            g.fillRoundRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight, 5, 5);
        }
player = new Player(new Position(1,2));
        // draw 'player'
        g.setFill(Color.BLACK);
        g.fillRoundRect(player.getPosition().getX() * fieldWidth, player.getPosition().getY() * fieldHeight, fieldWidth, fieldHeight, 3, 3);
    }
}
