package src.main.java.CVP;

import src.main.java.State;

import java.util.ArrayList;

public class Equation extends Expression{
    public ArrayList<Expression> expressions = new ArrayList <> ( );

    public void add (Expression e) {
        this.expressions.add ( e );
    }

    public void remove (Expression e) {
        this.expressions.remove ( e );
    }

    @Override
    public void accept (Visitor visitor, State state) {

        for (Expression e : expressions) {
            e.accept ( visitor , state);
        }
    }
}
