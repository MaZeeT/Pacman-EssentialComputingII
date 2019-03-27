package DataStructures;

import Components.Position;

//TODO write javaDoc
//TODO look into using an abstract class to DRY up the dataStructures a bit.
public interface IDataStructure {

    boolean contains(Position position);

    void add(Position position);

    Position checkNext();

    Position getNext();

}
