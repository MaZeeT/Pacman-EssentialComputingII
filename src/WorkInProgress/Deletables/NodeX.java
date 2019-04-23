package WorkInProgress.Deletables;

import WorkInProgress.Nodes.Node;

public class NodeX<T extends Comparable> extends Node<T> {
    private Node<T>[] branches;

    private NodeX(T contain, NodeX<T> parent, int NodeAmount) {
        super(contain, parent);
        this.branches = (Node<T>[]) new Object[NodeAmount];
        //new Node[NodeAmount];
    }

    public Node<T> getNode(int i) {
        if (insideLimit(i)) {
            return branches[i];
        } else {
            return null;
        }
    }

    public boolean addNode(int i, T contain) {
        if (insideLimit(i)) {
            branches[i] = new NodeX<>(contain, this, this.branches.length);
            return true;
        } else {
            return false;
        }

    }

    private boolean insideLimit(int i) {
        return 0 <= i && i <= branches.length + 1;
    }

}

