package WorkInProgress;

import WorkInProgress.Nodes.SimpleNode;

public class Tree<T> {
    //NodeX<T> root = new NodeX<>();

    SimpleNode<T> root;


    public void add(T item){
        new SimpleNode<T>(item,null);
    }

}
