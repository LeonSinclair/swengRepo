package lca;
import java.util.*;
public class Node<T>
{
    public T data;
    public Node<T> parent;
    public ArrayList<Node<T>> children;
    public T key;
    
    public Node(T keyIn,T value)
    {
        key = keyIn;
        data = value; 
        parent = null;
        children = new ArrayList<Node<T>>();       
    } 

    //makes first node the parent of the second
    public void connect(Node<T> child)
    {
        this.children.add(child);
        child.parent = this;
    }
}