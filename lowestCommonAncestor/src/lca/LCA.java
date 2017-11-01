package lca;
import java.util.*;

public class LCA
{
	//TODO modify class to use sets instead
    public static ArrayList<Node> findLowestCommonAncestor(ArrayList<Node> nodeList, Node a, Node b)
    {
        //we check if it is acyclic and if it is then we perform this algorithm. 
	    //Otherwise just return null
    	
    	if(nodeList == null || a == null || b == null || nodeList.size() == 0 ||!nodeList.contains(a) || !nodeList.contains(b) ) return null;
    	if(!checkAcyclic(nodeList)) return null;
    	ArrayList<Node> rootList = new ArrayList<Node>();
    	ArrayList<Node> ancestorA = new ArrayList<Node>();
    	ArrayList<Node> ancestorB = new ArrayList<Node>();
    	ArrayList<Node> commonAncestors = new ArrayList<Node>();
        for(int i = 0; i < nodeList.size(); i++)
        {
        	if(nodeList.get(i).indegree == 0)
        	{
        		rootList.add(nodeList.get(i));
        	}
        }
        
        
        //each node is considered an ancestor of itself
        ancestorA.add(a);
        ancestorB.add(b);
        for(int i = 0; i < rootList.size(); i++)
        {
        	search(rootList.get(i), ancestorA, ancestorB);
        }
        commonAncestors = intersection(ancestorA, ancestorB);
        if(commonAncestors.size() == 0) return null;
        while(commonAncestors.size() != 1)
        {
        	for(int i = 0; i < commonAncestors.size(); i++)
        	{
        		
        		if(checkForDeadlock(commonAncestors))
            	{
            		return commonAncestors;
            	}
        		//if its descendants are in the list of common ancestors then remove it as the descendant is a lower common ancestor
            	else
            	{
            		if(intersection(commonAncestors, commonAncestors.get(i).edgesTo).size() != 0)
            		{
            			commonAncestors.remove(i);
            		}
            	}
        	}	
        }
        return commonAncestors;
        
    }
    
    private static boolean checkForDeadlock(ArrayList<Node> commonAncestors) 
    {
		for(int i = 0; i < commonAncestors.size(); i++)
		{
			Node tmp = commonAncestors.get(i);
			if(intersection(commonAncestors, tmp.edgesTo).size() != 0)
    		{
    			return false;
    		}
		}
		return true;
	}

	public static void search(Node root, ArrayList<Node> ancestorA, ArrayList<Node> ancestorB)
    {
    	if(root.edgesTo == null || root.edgesTo.size() == 0) return;
    	
    	for(int i = 0; i < root.edgesTo.size(); i++)
    	{
    		Node tmp = (Node) root.edgesTo.get(i);
    		if(!(ancestorA.contains(tmp) || ancestorB.contains(tmp))) search(tmp, ancestorA, ancestorB);
    		if(ancestorA.contains(tmp)) ancestorA.add(root);
    		if(ancestorB.contains(tmp)) ancestorB.add(root);	
    	}
    }


	public static boolean checkAcyclic(ArrayList<Node> aList)
    {
        //TODO:
        //DFS effectively
		if(aList == null || aList.size() == 0) return true;
		
		for(int i = 0; i < aList.size(); i++)
		{
			ArrayList<Node> visited = new ArrayList<Node>();
			ArrayList<Node> stack = new ArrayList<Node>();
			Node src = aList.get(i);
			boolean hasCycle = false;
			hasCycle = cycleExists(aList, src, visited, stack, hasCycle);
			if(hasCycle)
			{
				return false;
			}
		}
        return true;
    }
	
	private static boolean cycleExists(ArrayList<Node> list, Node tmp, ArrayList<Node> visited, ArrayList<Node> stack, boolean hasCycle)
	{
		visited.add(tmp);
		stack.add(tmp);
		
		for(int i = 0; i < tmp.edgesTo.size(); i++)
		{
			Node a = (Node) tmp.edgesTo.get(i);
			if(!visited.contains(a)) 
			{
				hasCycle = hasCycle || cycleExists(list, a, visited, stack, hasCycle);
			}
			else if(stack.contains(a))
			{
				hasCycle = true;
				return hasCycle;
			}
		}
		stack.remove(tmp);
		return hasCycle;
	}
	/*
	 marked[v] = true;
     onStack[v] = true;

     for (int w : g.adjacentNodes(v)) {
         if(!marked[w]) {
             cycleExists(g,w);
         } else if (onStack[w]) {
             hasCycle = true;
             return;
         }
     }

     onStack[v] = false;*/
	
	//find all root nodes - that is nodes that have no incoming edges
	//we can recursively access all other nodes from these nodes
	//if the children of a node contains both targets we mark that as the lowest common ancestor
	//otherwise if it matches one of the nodes we mark it as an ancestor of that node i.e ancestorA ancestorB
	//can add them to an arraylist of ancestorA and ancestorB
	//then if a node is an ancestor of any of the nodes in ancestorA or ancestorB it becomes marked as an ancestor
	//create a common ancestor list by checking if the ancestor is contained in the opposite list
	//if there are multiple common ancestors found then we check all of them, and if anyone of them has another as a descendant we remove it from the list
	//repeat this until the size of the common ancestor array is 1
	

	public static ArrayList<Node> intersection(ArrayList<Node> list1, ArrayList<Node> list2) {
		ArrayList<Node>list = new ArrayList<Node>();

        for (Node n : list1) {
            if(list2.contains(n)) {
                list.add(n);
            }
        }

        return list;
    }



    
}