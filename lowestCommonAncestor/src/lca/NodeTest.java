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
  }
}
