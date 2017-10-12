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
        if(child != null)
        {
            this.children.add(child);
            child.parent = this;
        }
        
    }

    public void delete()
    {
        for(int i = 0; i < this.children.size(); i++)
        {
            this.children.get(i).parent = null;
        }
        this.children = null;
    }
}