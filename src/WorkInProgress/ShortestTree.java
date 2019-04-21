package WorkInProgress;

import Components.Position;
import Entities.GameObject;

import java.util.ArrayList;
import java.util.List;

// wrapper for a tree, to take a target, generate a path to the target,
// and on each update calls move 1 position closer, maybe use a queue.
public class ShortestTree {

    GameObject target;
    List<Position> list;

    public ShortestTree(GameObject target){
        this.target = target;
        list = new ArrayList<>();
    }



}
