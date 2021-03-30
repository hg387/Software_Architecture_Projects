package src.main.java;

import src.main.java.CVP.CalculateVisitor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static javax.swing.SwingConstants.CENTER;

public class CalculatorDisplay extends JFrame implements ActionListener {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    static State state;
    static JDialog dialog;
    JTextField calcDisplay = new JTextField();
    private ArrayList<JButton> numButtons = new ArrayList<>();
    private ArrayList<JButton> opButtons = new ArrayList<>();
    JButton[] jbuttons = {new JButton("Reset"), new JButton("Discard")};

    public ArrayList<JButton> getNumButtons() {
        return numButtons;
    }

    public ArrayList<JButton> getOpButtons() {
        return opButtons;
    }

    public void setState(State state) {
        CalculatorDisplay.state = state;

        if (CalculatorDisplay.state != null){
            CalculatorDisplay.state.addActionListener(this);
        }
    }

    public CalculatorDisplay(){

        JPanel numPad = new JPanel(new GridLayout(4,3,2,2));

        for (int i=1;i<=9;i++){
            JButton button = new JButton(Integer.toString(i));
            numPad.add(button);
            numButtons.add(button);
        }

        JButton button = new JButton("0");
        numPad.add(button);
        numButtons.add(button);

        button = new JButton("=");
        numPad.add(button);
        opButtons.add(button);

        button = new JButton("C");
        numPad.add(button);
        opButtons.add(button);

        JPanel operationPad = new JPanel(new GridLayout(4,1,2,2));
        button = new JButton("+");
        operationPad.add(button);
        opButtons.add(button);

        button = new JButton("-");
        operationPad.add(button);
        opButtons.add(button);

        button = new JButton("*");
        operationPad.add(button);
        opButtons.add(button);

        button = new JButton("/");
        operationPad.add(button);
        opButtons.add(button);

        JPanel buttonsPad = new JPanel(new GridLayout(1,2,10,0));
        buttonsPad.add(numPad);
        buttonsPad.add(operationPad);
        buttonsPad.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonsPad.setBackground(Color.white);

        calcDisplay.setEditable(false);
        Border empty = BorderFactory.createEmptyBorder(0,10,0,10);
        Border line = BorderFactory.createLineBorder(Color.BLACK,1);
        CompoundBorder border = new CompoundBorder(empty, line);
        calcDisplay.setBorder(border);
        calcDisplay.setBackground(Color.white);
        calcDisplay.setHorizontalAlignment(JTextField.RIGHT);

        JPanel labelPanel = new JPanel();
        JLabel label = new JLabel("<html><div style='text-align: center;'>"+"CALCULATOR"+"</div></html>");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        labelPanel.add(label);


        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(labelPanel);
        add(Box.createRigidArea(new Dimension(5,5)));
        add(calcDisplay);
        //add(Box.createRigidArea(new Dimension(2,2)));
        add(buttonsPad);


        setTitle("Calculator");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void makeDialog(){
        dialog = new JDialog(this);

        final JOptionPane optionPane = new JOptionPane(
                "Error\n"
                        + "Choose one of the following buttons.\n",
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                jbuttons,
                jbuttons[0]);
        dialog.add(optionPane);
        dialog.pack();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        CalculatorDisplay display = new CalculatorDisplay();
        State state = new State();
        display.setState(state);
        CalculateVisitor calcVisitor = new CalculateVisitor();
        CalculatorController controller = new CalculatorController(display, state, calcVisitor);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("display")){
            calcDisplay.setText(state.equation);
        }
        else if (e.getActionCommand().equals("display intermediate")){
            calcDisplay.setText(state.intermediate);
        }
        else if (e.getActionCommand().equals("state change") && state.getValue() != null){
            if (state.getValue() instanceof Double){
                calcDisplay.setText(df.format(state.getValue()));
            }
            else calcDisplay.setText(state.getValue().toString());
        }
        else if (e.getActionCommand().equals("error dialog")){
            this.makeDialog();
        }
    }
}
