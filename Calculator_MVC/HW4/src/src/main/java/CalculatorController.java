package src.main.java;

import src.main.java.CVP.CalculateVisitor;
import src.main.java.CVP.Equation;
import src.main.java.CVP.Num;
import src.main.java.CVP.Operation;

import java.io.IOException;
import java.net.Socket;

public class CalculatorController {
    public static Equation initialEq = new Equation();
    static State state;
    CalculatorDisplay calcDisplay;
    CalculateVisitor calcVisitor;

    public CalculatorController(CalculatorDisplay calcDisplay, State state, CalculateVisitor calcVisitor){
        this.calcDisplay = calcDisplay;
        CalculatorController.state = state;
        this.calcVisitor = calcVisitor;
        calcDisplay.getNumButtons().forEach(button -> button.addActionListener(e ->
                {
                    System.out.println("Pressed "+button.getText());
                    Num num = new Num();
                    num.setExp(button.getText());
                    initialEq.add(num);
                    if (state.value == null ) //|| state.status == Status.C)
                        state.setEquation(state.equation+button.getText());
                    else {
                        state.setIntermediate(state.intermediate+button.getText());
                        state.equation += button.getText();
                    }
                }
        ));

        calcDisplay.getOpButtons().forEach(button -> button.addActionListener(e->
        {
            System.out.println("Pressed "+button.getText());
            if ((button.getText().equals("C") ||
                    (state.status == Status.C && CalculatorController.initialEq.expressions.isEmpty())))
            {
                state.reset();
                state.status = Status.C;
                state.value = null;
                state.setEquation("");
                state.intermediate = "";
                CalculatorController.initialEq = new Equation();
                return;
            }


            Operation op = new Operation();
            op.setExp(button.getText());
            initialEq.add(op);

            if (state.status == Status.O)
                this.calcVisitor.visit(initialEq, CalculatorController.state);

            if (!((state.first != null && button.getText().equals("=") && state.second == null)
                    || (state.operator != null && state.first != null && state.second == null)))
            {
                if (state.status == Status.O)
                    state.equation += button.getText();
                else if (!button.getText().equals("="))
                    state.setEquation(state.equation + button.getText());

                if (!button.getText().equals("=")) state.status = Status.O;
            }
        }));

        calcDisplay.jbuttons[0].addActionListener((e)->{
            CalculatorDisplay.dialog.setVisible(false);
            state.reset();
            state.status = Status.C;
            state.value = null;
            state.setEquation("");
            state.intermediate = "";
            CalculatorController.initialEq = new Equation();
            CalculatorDisplay.dialog.dispose();
        });

        calcDisplay.jbuttons[1].addActionListener((e)->{
            CalculatorDisplay.dialog.setVisible(false);
            CalculatorDisplay.dialog.dispose();
            CalculatorController.initialEq = new Equation();
        });
    }
}
