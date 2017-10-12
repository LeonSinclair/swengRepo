package lca;
import junit.framework.TestCase;
public class NodeTest extends TestCase 
{
  
  public void testConnect()
  {
    Node a = new Node("a", 17);
    Node b = new Node("b", 16);
    a.connect(b);
    assertTrue(a.children.size()==1);
    assertTrue(b.parent.equals(a));
    b.connect(a);
    assertTrue(b.children.size()==1);
    assertTrue(a.parent.equals(b));
    b.connect(null);
    assertTrue(b.children.size()==1);
  }

  public void testDelete()
  {
    Node a = new Node("a", 17);
    Node b = new Node("b", 16);
    Node c = new Node("c", 18);
    a.connect(b);
    a.connect(c);
    LCA.delete(a);
    assertEquals("Testing parentage b", null, b.parent);
    assertEquals("Testing parentage c", null, c.parent);
  }
}
