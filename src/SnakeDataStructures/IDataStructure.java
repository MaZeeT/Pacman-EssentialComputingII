package SnakeDataStructures;

import SnakeComponents.Position;

public interface IDataStructure {

    boolean contains(Position position);

    void add(Position position);

    Position checkNext();

    Position getNext();


}
