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
            for (var polygon : state.polygons) {
                drawPolygon((Graphics2D)g, polygon, state.mood);
            }
        }
    }
    public void drawPolygon(Graphics2D g, Polygon polygon, double mood)
    {
        Color color;
        if(mood<-1)color = Color.RED;else if(mood<-0.5)color = Color.MAGENTA;else if(mood<0)color = Color.YELLOW;else if(mood>7)color = Color.cyan;else if(mood>4)color = Color.GREEN;else if(mood>1)color = new Color(195,124,50);else if(mood>0.5)color = Color.PINK;else if(mood>0)color = Color.BLUE;else color = Color.GRAY;
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        g.draw(polygon);
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
        g.fill(polygon);

    }
}
