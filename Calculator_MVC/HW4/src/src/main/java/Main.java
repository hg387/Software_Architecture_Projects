package src.main.java;

import src.main.java.CVP.CalculateVisitor;

public class Main {

    public static void main(String[] args){
        CalculatorDisplay display = new CalculatorDisplay();
        State state = new State();
        display.setState(state);
        CalculateVisitor calcVisitor = new CalculateVisitor();
        CalculatorController controller = new CalculatorController(display, state, calcVisitor);

    }
}
