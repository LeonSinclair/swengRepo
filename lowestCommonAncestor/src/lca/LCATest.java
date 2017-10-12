package lca;
import junit.framework.TestCase;
import java.util.*;
public class LCATest extends TestCase 
{

  
  //note this also tests the ancestryListToString method effectively
  public void testAncestryPopulation()
  {
    Node a = new Node("a",1);
    Node b = new Node("b",3);
    Node c = new Node("c",42);
    Node d = new Node("d",188);
    a.connect(b);
    b.connect(c);
    a.connect(d);
    ArrayList<Node> cList = LCA.populateAncestryList(c);
    String cListStr = LCA.ancestryListToString(cList);
    assertEquals("Testing Ancestry of C","[b,a]", cListStr);

    ArrayList<Node> dList = LCA.populateAncestryList(d);
    String dListStr = LCA.ancestryListToString(dList);
    assertEquals("Testing Ancestry of D","[a]", dListStr);
  }

  public void testFindLCA()
  {
    Node a = new Node("a",1);
    Node b = new Node("b",3);
    Node c = new Node("c",42);
    Node d = new Node("d",188);
    a.connect(b);
    b.connect(c);
    a.connect(d);
    ArrayList<Node> cList = LCA.populateAncestryList(c);
    ArrayList<Node> dList = LCA.populateAncestryList(d);
    assertEquals("Testing Lowest Common Ancestor", a, LCA.findLowestCommonAncestor(cList, dList));
  }

  
}