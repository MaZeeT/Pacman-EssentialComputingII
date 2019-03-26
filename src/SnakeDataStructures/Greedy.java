package SnakeDataStructures;

import SnakeComponents.Position;
import SnakeComponents.PositionManhattan;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

//TODO write tests
//TODO sort by manhattan distances

/**
 * The purpose of this class is to make "greedy" behavior when selecting which moves to take.
 * This "greedy" dataStructure implement the {@link IDataStructure} interface which make it compatible with
 * the {@link SnakeLogic.Crawler.Crawler}.
 * The "greedy" behavior is defined by, the next move should be the one with lowest manhattan distance.
 *
 * @author MaZeeT
 */
public class Greedy implements IDataStructure {

    private List<PositionManhattan> list = new ArrayList<>();
    private List<PositionManhattan> visitedList = new ArrayList<>();
    private Position target;

    public Greedy(Position targetPosition){
        this.target = targetPosition;
    }

    /**
     * Checks if the given {@link Position} is in the visitedList.
     *
     * @param position The given {@link Position} that needs to be checked if it is already present in the visited list.
     * @return Returns a boolean depending on if the {@link Position} is present in the visited list or not.
     */
    @Override
    public boolean contains(Position position) {
        return visitedList.contains(position);
    }

    /**
     * Adds a {@link Position} if it isn't already in the list of visited positions.
     * Will be casted as a {@link PositionManhattan} in the process of adding it to the visited list.
     *
     * @param position The {@link Position} that should be added to the lists if not already present.
     */
    @Override
    public void add(Position position) {
        if (!contains(position)) {
            PositionManhattan pos = new PositionManhattan(position);
            pos.getDistanceTo(target);
            visitedList.add(pos);
            list.add(pos);
            sort(list,reverseOrder());
        }
    }

    /**
     * Get the {@link Position} with the lowest distance and keeps the {@link Position} from the list of possible moves.
     *
     * @return Returns the {@link Position} with the lowest distance and keep the {@link Position} in the list.
     */
    @Override
    public Position checkNext() {
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * Get the {@link Position} with the lowest distance and removes the {@link Position} from the list of possible moves.
     *
     * @return Returns the {@link Position} with the lowest distance and remove the {@link Position} from the list.
     */
    @Override
    public Position getNext() {
        if (!list.isEmpty()) {
            Position rtn = list.get(0);
            list.remove(0);
            return rtn;
        } else {
            return null;
        }
    }

    /**
     * A method to cast a {@link Position} into a {@link PositionManhattan}.
     *
     * @param position The given {@link Position} that need to be casted.
     * @return Returns the given {@link Position} as a {@link PositionManhattan}.
     */
    private PositionManhattan cast(Position position) {
        PositionManhattan positionManhattan = null;
        try {
            positionManhattan = (PositionManhattan) position;

        } catch (ClassCastException e) {
            System.out.println("Could not cast to a Manhattan position");
        }
        return positionManhattan;
    }

}
