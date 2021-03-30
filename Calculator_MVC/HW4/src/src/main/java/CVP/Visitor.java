package src.main.java.CVP;

import src.main.java.State;

public interface Visitor {
    public void visit(Equation eq, State state);

    public void visit(Num num, State state);

    public void visit(Operation operation, State state);
}
