package com.gupta.main.java.output;

import com.gupta.main.java.*;
import com.gupta.main.java.Event.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OutputConsoleTasker extends ActionHandler implements Output, ActionListener {

    public void outputManager(){
        LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        ArrayList<String> lines = lineStorage.getLines();
        System.out.println("Here is the Output:\n");
        lines.forEach(System.out::println);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Output Now")) {
            this.outputManager();
            processEvent(new Event().InteractiveTasker());
        }
    }
}
