package SnakeDataStructures;

import SnakeComponents.Position;

//TODO write javaDoc
public interface IDataStructure {

    boolean contains(Position position);

    void add(Position position);

    Position checkNext();

    Position getNext();

}
