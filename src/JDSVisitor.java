public abstract class JDSVisitor {
    public abstract void visit(JDSNode node);
    public void report() { 
	System.out.println("None.");
    }
}