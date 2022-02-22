package classes;

import java.awt.*;
import java.util.LinkedList;

public class State {
    public LinkedList<LinkedList<Point>> Border = new LinkedList<>();
    public LinkedList<Polygon> polygons = new LinkedList<>();
    public String Name;
    public State(){}
    public State(String Name,LinkedList<LinkedList<Point>> Border){this.Name = Name; this.Border = Border;}
    public void Increase(double num)
    {
        for(LinkedList<Point> List:Border)
        {
            for(Point point: List)
            {
                point.XY.x=(int) Math.round(point.XY.getX()*num);
                point.XY.y=(int) Math.round(point.XY.getY()*num);
            }
        }
    }
    public void Shift(int shiftY,int shiftX)
    {
        for(LinkedList<Point> List:Border)
        {
            for(Point point: List)
            {
                point.XY.y+=shiftY;
                point.XY.x+=shiftX;
            }
        }
    }

}
