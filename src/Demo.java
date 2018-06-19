public class Demo {
    private static JDSVisitor visitor;
    private static JDSNode root;

    public static void main(String[] args) {
	processCommandLine(args);
	

	System.out.println("Beginning visitation");
	JDSTraverser traverser = new JDSTraverser(visitor);
	traverser.traverse(root);
	System.out.println("Visitation ended.");

	System.out.println("Visitor report.");
	visitor.report();

	System.out.println("Over and out.");
    }

    private static JDSNode buildRandomIntegerJDS(int size) {
	JDSNode root = new JDSNode(new Integer(1));
	for (int i=2; i <= size; i++) {
	    root.addChild(new Integer(i));
	}
	System.out.println();
	return root;
    }

    private static void processCommandLine(String[] args) {
	int size = 15;
	boolean argsProbs = false;
	if (args.length > 0) {
	    if ("countOdds".equals(args[0])) {
		visitor = new JDSCountOdds();
	    }
	    else if ("prettyPrint".equals(args[0])) {
		visitor = new JDSPrettyPrinter();
	    }
	    else {
		argsProbs = true;
	    }
	}
	if (args.length > 2) {
	    try {
		size = Integer.parseInt(args[2]);
		if (size > 20) {
		    argsProbs = true;
		}
	    }
	    catch (Exception e) {
		argsProbs = true;
	    }
	}
	if (args.length > 1) {
	    if ("int".equals(args[1])) {
		root = buildRandomIntegerJDS(size);
	    }
	    else {
		argsProbs = true;
	    }
	}

	if (argsProbs || args.length == 0) {
	    System.out.println("\nCommand line args: visitor type size");
	    System.out.println("visitor: prettyPrint, countOdds");
	    System.out.println("type: int");
	    System.out.println("size: positive # < 20");
	    System.out.println();
	    System.out.println("Using defaults: prettyPrint int 15");
	    visitor = new JDSPrettyPrinter();
	    root = buildRandomIntegerJDS(15);
	}
    }
}