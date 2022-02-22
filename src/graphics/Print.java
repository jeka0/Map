package graphics;

import classes.State;
import database.DB;
import classes.Point;

import javax.swing.*;
import java.awt.*;

public class Print extends JPanel {
    public DB db=DB.db;
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (State state : db.States) {
            for (var points : state.Border) {
                Polygon polygon = new Polygon();
                for (Point a : points) {
                    polygon.addPoint((int)a.XY.getX(), (int)a.XY.getY());
                }
                state.polygons.add(polygon);
                g.drawPolygon(polygon);
            }
        }
    }
}
