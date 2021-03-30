package src.main.java.CVP;

import src.main.java.CalculatorController;
import src.main.java.State;
import src.main.java.Status;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateVisitor implements Visitor {
    private ArrayList<String> operations = new ArrayList<>(){{
       add("+");
       add("-");
       add("*");
       add("/");
    }};

    @Override
    public void visit(Equation eq, State state) {
        eq.accept(this, state);
    }

    @Override
    public void visit(Num num, State state) {

        if (state.operator == null){
            if (state.first != null){
                String tmp = state.first.toString();
                tmp += num.getExp();
                state.first = Integer.valueOf(tmp);

            }
            else{
                state.first = Integer.valueOf(num.getExp());

            }
        }
        else if (state.first != null){
            if (state.second != null){
                String tmp = state.second.toString();
                tmp += num.getExp();
                state.second = Integer.valueOf(tmp);

            }
            else{
                state.second = Integer.valueOf(num.getExp());

            }
        }

    }

    @Override
    public void visit(Operation operation, State state) {
        String exp = operation.getExp();

        if ((state.first != null && exp.equals("=") && state.second == null)
            || (state.operator != null && state.first != null && state.second == null)){
            state.showDialog();
            return;
        }

        if ((operations.contains(exp) || exp.equals("=")) && state.first != null && state.second != null){

            Number tmpValue = this.doOperation(state.operator, state.first, state.second);
            state.setValue(tmpValue);

            state.reset();

            if (exp.equals("=") && tmpValue != null){
                state.equation += exp + tmpValue.toString();
                System.out.println("Calculated "+state.equation);

                // send successful equation to the server
                state.writeToServer();

                state.status = Status.C;
                state.equation = "";
                state.intermediate = "";
                CalculatorController.initialEq = new Equation();
                state.value = null;
                return;
            }
            else{
                state.first = tmpValue;
                state.operator = exp;
                state.setIntermediate(tmpValue.toString()+exp);
                state.equation += state.operator;
                CalculatorController.initialEq = new Equation();
                return;
            }


        }
        if (state.operator == null) state.operator = exp;
    }

    private Number doOperation(String Operation, Number first, Number second){
        Integer fst1 = null;
        Integer snd1 = null;
        Double fst2 = null;
        Double snd2 = null;

        if (first instanceof Integer){
            fst1 = (Integer) first;
        }
        else fst2 = (Double) first;

        if (second instanceof Integer){
            snd1 = (Integer) second;
        }
        else snd2 = (Double) second;

        if (Operation.equals("+")) return (fst1 == null ? fst2 : fst1) + (snd1 == null ? snd2 : snd1);
        else if (Operation.equals("-")) return (fst1 == null ? fst2 : fst1) - (snd1 == null ? snd2 : snd1);
        else if (Operation.equals("*")) return (fst1 == null ? fst2 : fst1) * (snd1 == null ? snd2 : snd1);
        else if (Operation.equals("/")) return (fst1 == null ? fst2 : fst1) / (snd1 == null ? snd2 : snd1);
        else return null;
    }
}
