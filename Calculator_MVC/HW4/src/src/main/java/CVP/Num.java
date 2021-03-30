package src.main.java.CVP;

import src.main.java.State;

public class Num extends Expression{

    @Override
    public void accept(Visitor visitor, State state){
        visitor.visit(this, state);
    }
}
