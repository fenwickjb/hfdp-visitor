public class JDSPrettyPrinter extends JDSVisitor {

    public void visit(JDSNode node) {
	
	// Work with current node
	Integer nodeData = (Integer) node.getData();
	int value = nodeData.intValue();
	
	System.out.println("JDSNode(@" + node.hashCode()
			   + ") contains Integer(@" + nodeData.hashCode()
			   + ") containing (" + value + ")");

	// This looks into JDS structure to get children addresses
	// BUT IS NOT ACTUALLY TRAVERSING/VISITING THE CHILDREN
	System.out.print("\tMy children: ");
	Object[] childrenObjs = node.getChildren();
	for (Object obj : childrenObjs) {
	    System.out.print(" @" + obj.hashCode());
	}
	System.out.println();
    }
}