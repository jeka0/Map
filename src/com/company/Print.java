package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Print extends JPanel {
    public LinkedList<State> States;

    public void paint(Graphics g) {
        super.paintComponent(g);
        for (State state : States) {
            for (var points : state.Border) {
                Polygon polygon = new Polygon();
                for (Point a : points) {
                    polygon.addPoint(a.newX, a.newY);
                }
                g.drawPolygon(polygon);
            }
        }
    }
}
