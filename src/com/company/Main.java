package com.company;

public class Main {

    public static void main(String[] args) {
        JsonPars pars = new JsonPars("Data\\states.json");
        pars.ParsObject();
        GUI app = new GUI();
        Print print = new Print();
        print.States = pars.States;
        app.add(print);
        app.setVisible(true);
    }
}
