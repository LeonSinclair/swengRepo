package lca;
import junit.framework.TestCase;
import java.util.*;
public class LCATest extends TestCase 
{

  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void testFindLCA()
  {
    Node a = new Node("a",1);
    Node b = new Node("b",3);
    Node c = new Node("c",42);
    Node d = new Node("d",188);
    
    a.connect(b);
    b.connect(c);
    a.connect(d);
    assertEquals("Testing null inputs", null, LCA.findLowestCommonAncestor(null, null, null));
    assertEquals("Testing null inputs", null, LCA.findLowestCommonAncestor(null, a, null));
    assertEquals("Testing null inputs", null, LCA.findLowestCommonAncestor(null, null, b));
    
    ArrayList<Node> list = new ArrayList<Node>();
    assertEquals("Testing empty list", null, LCA.findLowestCommonAncestor(list, a, b));
   
    list.add(a);
    list.add(b);
    assertEquals("Testing with node not in list", null, LCA.findLowestCommonAncestor(list, c, b));
    list.add(c);
    list.add(d);
    ArrayList<Node> answers = new ArrayList<Node>();
    answers.add(a);
    //returns true if there is a change, so false means they are the same thing
    assertEquals("Testing LCA with one Common Ancestor.", false, answers.retainAll(LCA.findLowestCommonAncestor(list, c, d)));
    
    Node e = new Node("e",200);
    e.connect(b);
    list.add(e);
    assertEquals("Testing LCA with one Common Ancestor.", false, answers.retainAll(LCA.findLowestCommonAncestor(list, c, d)));
    e.connect(d);
    answers.add(e);
    assertEquals("Testing LCA with two Common Ancestors.", false, answers.retainAll(LCA.findLowestCommonAncestor(list, c, d)));
    
    Node f = new Node("f", 199);
    f.connect(a);
    f.connect(c);
    list.add(f);
    assertEquals("Testing LCA with two Common Ancestors.", false, answers.retainAll(LCA.findLowestCommonAncestor(list, c, d)));

    b.connect(a);
    assertEquals("Testing LCA with a cycle.", null, LCA.findLowestCommonAncestor(list, c ,d));
    b.disconnect(a);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
public void testAcylic()
  {
    assertEquals("Testing for Cycles with null List", true, LCA.checkAcyclic(null));
    
    ArrayList<Node> cycleList = new ArrayList<Node>();
    Node a = new Node("a",1);
    cycleList.add(a);
    assertEquals("Testing for Cycles with 1 element list", true, LCA.checkAcyclic(cycleList));
    
    Node b = new Node("b",3);
    Node c = new Node("c",42);
    Node d = new Node("d",188);
    
    a.connect(b);
    b.connect(c);
    a.connect(d);
      
    cycleList.add(b);
    cycleList.add(c);
    cycleList.add(d);
    
    assertEquals("Testing for Cycles", true, LCA.checkAcyclic(cycleList));
    d.connect(a);
    assertEquals("Testing for Cycles", false, LCA.checkAcyclic(cycleList));
    c.connect(a);
    assertEquals("Testing for Cycles", false, LCA.checkAcyclic(cycleList));
  }

  
}