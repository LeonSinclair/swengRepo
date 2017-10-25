package lca;
import java.util.*;
public class Node<T>
{
     
    public T data;
    public ArrayList<Node<T>> edgesTo;
    public T key;
    public int indegree;
    public int outdegree;
    
    public Node(T keyIn,T value)
    {
        key = keyIn;
        data = value; 
        edgesTo = new ArrayList<Node<T>>();
        indegree = 0;
        outdegree = edgesTo.size();
    } 

    //adds an edge to a child Node
    public void connect(Node<T> child)
    {
        if(child != null)
        {
            this.edgesTo.add(child);
            child.indegree++;
        }
        
    }

    public void deleteFrom(ArrayList<Node<T>> a)
    {
        if(a==null) return;
        for(int i = 0; i < a.size(); i++)
        {
            Node<T> tmp = a.get(i);
            if(tmp.edgesTo.contains(this))
            {
                tmp.edgesTo.remove(tmp.edgesTo.indexOf(this));
            }
        }
        this.edgesTo = null;
    }
    
    public void disconnect(Node<T> child)
    {
    	if(child!=null)
    	{
    		this.edgesTo.remove(child);
    		child.indegree--;
    	}
    }
    
    public String toString()
    {
    	return this.key.toString();
    }


}