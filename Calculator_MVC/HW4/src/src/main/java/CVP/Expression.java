package src.main.java.CVP;

import src.main.java.State;

public class Expression {

    private String exp;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void accept(Visitor visitor, State state){
        ;
    }
}
