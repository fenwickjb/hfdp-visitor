public class JDSTraverser {
    private JDSVisitor visitor;
    public JDSTraverser(JDSVisitor v) { visitor = v; }
    public void traverse(JDSNode node) {
	
	// visit current node
	node.accept(visitor);

	// Continue visiting rest of structure
	Object[] moreNodes = node.getChildren();
	for (Object nextNode : moreNodes) {
	    JDSNode nextJDSNode = (JDSNode) nextNode;
	    traverse(nextJDSNode);
	}
    }
}