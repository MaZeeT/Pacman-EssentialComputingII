package SnakeEntities;

import SnakeComponents.Position;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to define a {@link GameObject},
 * that can be the "target/goal" for the {@link SnakeLogic.Crawler.Crawler}.
 *
 * @author MaZeeT
 */
public class WayPoint extends GameObject {

    /**
     * This constructor takes a {@link Position} to define where the wayPoint should be.
     *
     * @param position The {@link Position} parameter defines where the wayPoint will be placed.
     */
    public WayPoint(Position position) {
        this.position = position;
        this.color = Color.GREEN;
    }

}
