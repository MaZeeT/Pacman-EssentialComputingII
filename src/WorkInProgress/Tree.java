package WorkInProgress;

import WorkInProgress.Nodes.SimpleNode;

//TODO implement a tree
//TODO Make a shortest route algorithm based on a tree.
public class Tree<T> {
    //NodeX<T> root = new NodeX<>();

    SimpleNode<T> root;


    public void add(T item){
        new SimpleNode<T>(item,null);
    }

}
