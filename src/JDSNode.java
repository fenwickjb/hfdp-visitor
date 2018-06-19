import java.util.ArrayList;
import java.util.Random;

/*
  A "Jays Data Structure" (JDS) consits of a collection of JDSNode objects.
  
  Each node object "wraps" some other data object.
  Each node has a variable number of children.

  The addChild method randomizes if new nodes are inserted as immediate
  child of current node or a further descendent. 
  If not an immediate child then it randomizes which child "subtree" it
  goes into.
 */
public class JDSNode {
    private Object data;
    private ArrayList<JDSNode> children;
    static private Random random;
    public JDSNode(Object o) { 
	data = o;
	children = new ArrayList<JDSNode>();
	random = new Random();
    }
    public Object getData() { return data; }
    public void addChild(Object o) {
	// 20% of additions are as children, rest go deeper to random child
	double asChildProbability = random.nextDouble();
	if (children.size() == 0) {
	    children.add(new JDSNode(o));
	}
	else if (asChildProbability < 0.2) {
	    children.add(new JDSNode(o));
	}
	else {
	    double whichChildProbability = random.nextDouble();
	    int child = (int) (whichChildProbability * children.size());
	    JDSNode jdsNode = (JDSNode) children.get(child);
	    jdsNode.addChild(o);
	}
    }
    public Object[] getChildren() {
	return children.toArray();
    }

    public void accept(JDSVisitor visitor) {
	visitor.visit(this);
    }
}