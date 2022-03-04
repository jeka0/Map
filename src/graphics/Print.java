package graphics;

import classes.State;
import database.DB;
import classes.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Print extends JPanel {
    public DB db=DB.db;
    public void paint(Graphics g) {
        super.paintComponent(g);
        drawMapLegend((Graphics2D) g);
        for (State state : db.States) {
            for (var polygon : state.polygons) {
                drawPolygon((Graphics2D)g, polygon, state.mood);
            }
            drawName((Graphics2D)g,state);
        }
        //drawPoints((Graphics2D)g);
    }
    public void drawPoints(Graphics2D g)
    {
        DB db = DB.db;
        for(Tweet tweet:db.Tweets)
        {
            g.setColor(chooseColor(tweet.mood));
            g.drawOval((int)tweet.location.XY.getX(),(int)tweet.location.XY.getY(),1,1);
        }
    }
    public void drawName(Graphics2D g,State state)
    {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4));
        g.drawString(state.Name,(int)state.center.getX(),(int)state.center.getY());
    }
    public void drawMapLegend(Graphics2D g)
    {
        LinkedList<Color> colors = new LinkedList<>();
        colors.add(Color.cyan);colors.add(Color.GREEN);colors.add(new Color(195,124,50));
        colors.add(Color.PINK);colors.add(Color.BLUE);colors.add(Color.GRAY);
        colors.add(Color.YELLOW);colors.add(Color.MAGENTA);colors.add(Color.RED);
        int y =500,i=0;
        for(Color color:colors)
        {
            String str ="";
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(2));
            switch(i)
            {
                case 0:str = "больше 7"; break;
                case 1:str = "от 4 до 7"; break;
                case 2:str = "от 1 до 4"; break;
                case 3:str = "от 0.5 до 1"; break;
                case 4:str = "от 0 до 0.5"; break;
                case 5:str = "рабно 0"; break;
                case 6:str = "от -0.5 до 0"; break;
                case 7:str = "от -1 до -0.5"; break;
                case 8:str = "меньше -1"; break;
            }
            g.drawString(str,100,y);
            g.setColor(color);
            g.setStroke(new BasicStroke(5));
            g.drawLine(10,y,90,y);
            y+=25;i++;
        }
    }
    public Color chooseColor(double mood)
    {
        if(mood<-1)return Color.RED;else if(mood<-0.5)return Color.MAGENTA;else if(mood<0)return Color.YELLOW;else if(mood>7)return Color.cyan;else if(mood>4)return Color.GREEN;else if(mood>1)return new Color(195,124,50);else if(mood>0.5)return Color.PINK;else if(mood>0)return Color.BLUE;else return Color.GRAY;
    }

    public void drawPolygon(Graphics2D g, Polygon polygon, double mood)
    {
        Color color = chooseColor(mood);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        g.draw(polygon);
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
        g.fill(polygon);

    }
}
