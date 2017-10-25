package lca;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;
public class NodeTest extends TestCase 
{
  
	@SuppressWarnings({ "unchecked", "rawtypes" })
  public void testConnect()
  {
    Node a = new Node("a", 17);
    Node b = new Node("b", 16);
    a.connect(b);
    assertTrue(a.edgesTo.size()==1);
    b.connect(a);
    assertTrue(b.edgesTo.size()==1);
    b.connect(null);
    assertTrue(b.edgesTo.size()==1);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void testDelete()
  {
    Node a = new Node("a", 17);
    Node b = new Node("b", 16);
    Node c = new Node("c", 18);
    ArrayList<Node> list = new ArrayList<Node>(Arrays.asList(a,b,c));
    a.connect(b);
    a.connect(c);
    c.deleteFrom(list);
    assertEquals("Checking deletion works", false, a.edgesTo.contains(c));
    c.deleteFrom(list);
    assertEquals("Checking deletion of element that is not in list", false, a.edgesTo.contains(c));
    
  }

  public void testToString()
  {
    Node a = new Node("a", 17);
    Node b = new Node(false, 16);
    Node c = new Node(22, 18);
    assertEquals("Testing toString", "a", a.toString());
    assertEquals("Testing toString", "false", b.toString());
    assertEquals("Testing toString", "22", c.toString());
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public void testDisconnect()
  {
	Node a = new Node("a", 17);
    Node b = new Node("b", 16);
    a.connect(b);
    b.connect(a);
    b.connect(null);
    a.disconnect(b);
    assertTrue(a.edgesTo.size()==0);
    
    assertTrue(b.edgesTo.size()==0);
    b.disconnect(a);
    assertTrue(b.edgesTo.size()==0);
    b.disconnect(null);
    assertTrue(b.edgesTo.size()==0);
  }

}
