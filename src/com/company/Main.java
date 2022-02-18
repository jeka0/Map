package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        JsonPars pars = new JsonPars("Data\\states.json");
        pars.ParsObject();
        ChangeStatesPosition(pars.States);
        GUI app = new GUI();
        Print print = new Print();
        print.States = pars.States;
        app.add(print);
        app.setVisible(true);
    }
    public static void ChangeStatesPosition(LinkedList<State> States)
    {
        for(State state:States)
        {
            if(!state.Name.equals("AK")&&!state.Name.equals("HI")){state.Shift(-300,-120);state.Increase(1.3);}
            if(state.Name.equals("HI")){state.Shift(-550,-150);state.Increase(3);}
        }
    }

}
