package DataStructures;

import DataStructures.Nodes.SimpleNode;

//TODO replace Position with T
public class Tree<T> {
    //NodeX<T> root = new NodeX<>();

    SimpleNode<T> root;


    public void add(T item){
        new SimpleNode<T>(item,null);
    }


}
