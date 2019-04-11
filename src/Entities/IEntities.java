package Entities;

import Components.Position;
import javafx.scene.paint.Color;

public interface IEntities extends Comparable<IEntities> {
    Color getColor();

    void setColor(Color color);

    Position getPosition();

    void setPosition(Position position);

    int compareTo(IEntities other);

}
