package com.gupta.main.java.Event;

import java.awt.event.ActionEvent;

public class Event {

    public ActionEvent InteractiveTasker(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Interactive Tasker");
    }

    public ActionEvent CircularShifterAdd(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Circular Shifter Add");
    }

    public ActionEvent Print(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Print");
    }

    public ActionEvent CallOutput(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Call Output");
    }

    public ActionEvent OutputNow(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Output Now");
    }

    public ActionEvent CircularShifterAddedLine(){
        return new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "CircularShifter Added Line");
    }
}
