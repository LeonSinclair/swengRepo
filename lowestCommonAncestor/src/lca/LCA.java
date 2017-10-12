package lca;
import java.util.*;

public class LCA
{

    public static void main(String [] args)
    {
        //populateAncestryList();
        //findLowestCommonAncestor();
    }
    //cases: 0 nodes, 1 node (root) and many nodes
    public static ArrayList<Node> populateAncestryList(Node a)
    {
        ArrayList<Node> ancestors = new ArrayList<Node>();
        Node tmp = a;
        //if 0 or 1 node then will return empty arraylist as no ancestors
        if(tmp != null)
        {
            while(tmp.parent != null)
            {
                ancestors.add(tmp.parent);
                tmp = tmp.parent;
            }
        }
        return ancestors;
    }

    public static Node findLowestCommonAncestor(ArrayList<Node> aList, ArrayList<Node> bList)
    {
        for(int i = 0; i < aList.size(); i++)
        {
            for(int j = 0; j < bList.size(); j++)
            {
                if(bList.get(j).key.equals(aList.get(i).key))
                {
                    System.out.println("Found a match!");
                    return(bList.get(j));
                }
            }
        }
        return null;
    }

    public static String ancestryListToString(ArrayList<Node> ancestors)
    {
        if(ancestors == null) return null;
        String ret = "[";
        
        for(int i = 0; i < ancestors.size(); i++)
        {
            if(i!=ancestors.size()-1) ret += ancestors.get(i).key.toString() + ",";
            else ret += ancestors.get(i).key.toString();
        }
        ret += "]";
        return ret;
    }



    
}