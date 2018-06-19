public class JDSCountOdds extends JDSVisitor {
    private int numOdds = 0;

    @Override
    public void report() {
	System.out.println("Num odds counted was " + getNumOdds());
    }

    public int getNumOdds() { return numOdds; }

    public void visit(JDSNode node) {
	
	// Work with current node
	Integer nodeData = (Integer) node.getData();
	int value = nodeData.intValue();
	if (value % 2 == 1) {
	    numOdds++;
	    //System.out.println(""+value + " is odd.");
	}
	else {
	    //System.out.println(""+value + " is not odd.");
	}
    }
}