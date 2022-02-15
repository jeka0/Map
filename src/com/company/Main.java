package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*GUI app = new GUI(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //С этого момента приложение запущено!*/
        JsonPars pars = new JsonPars("Data\\states.json");
        pars.ReadFile();
        for (State state: pars.States) {System.out.println(state.Name);
            for (var points : state.Border) {
                for (Point a: points) {
                    System.out.print("{"+a.x + "," + a.y + "}");
                }
                System.out.println();
            }
        }
    }
}
