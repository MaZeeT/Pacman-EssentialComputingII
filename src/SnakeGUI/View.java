package SnakeGUI;

import SnakeEntities.Item;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class View {
    Button btnStart = new Button("start");

    Label labelStatus = new Label("Label");
    HBox hBox = new HBox();
    Canvas canvas = new Canvas(600.0,357.0);
    public BorderPane pane = new BorderPane();

    int X;
    int Y;
    ArrayList<Item> items;

    View(int x, int y, ArrayList<Item> items){
        this.X = x;
        this.Y = y;
        this.items = items;

        hBox.getChildren().addAll(btnStart,labelStatus);
        pane.setTop(hBox);
        pane.setCenter(canvas);
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

        g.clearRect(0,0,width*fieldWidth ,height*fieldHeight);

        // draw items
        for (Item item : items)
        {
            g.setFill(item.getColor());
            int x = item.getPosition().getX();
            int y = item.getPosition().getY();
            g.fillRoundRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight, 5,5);
        }

        // draw 'player'
        g.setFill(Color.WHITE);
        g.fillRoundRect(this.X * fieldWidth, this.Y * fieldHeight, fieldWidth, fieldHeight, 3, 3);
    }
}
