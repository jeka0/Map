package com.company;

import classes.State;
import database.DB;
import database.JsonPars;
import database.ParsTweets;
import graphics.GUI;
import graphics.Print;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        JsonPars pars = new JsonPars("Data\\states.json");
        ParsTweets tPars = new ParsTweets();
        pars.ParsObject();
        tPars.ReadFile("Data\\cali_tweets2014.txt");

        ChangeStatesPosition(DB.db.States);
        GUI app = new GUI();
        Print print = new Print();
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
