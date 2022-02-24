package classes;

import java.awt.*;
import java.util.LinkedList;

public class State {
    public LinkedList<LinkedList<Point>> Border = new LinkedList<>();
    public LinkedList<Polygon> polygons = new LinkedList<>();
    public double mood;
    public String Name;
    public State(){}
    public State(String Name,LinkedList<LinkedList<Point>> Border){this.Name = Name; this.Border = Border;}
    public void Increase(double num)
    {
        for(Polygon polygon:polygons)
        {
            for(int i=0; i<polygon.xpoints.length;i++)
            {
                polygon.xpoints[i]=(int) Math.round(polygon.xpoints[i]*num);
                polygon.ypoints[i]=(int) Math.round(polygon.ypoints[i]*num);
            }
        }
    }
    public void Shift(int shiftY,int shiftX)
    {
        for(Polygon polygon:polygons)
        {
            for(int i=0; i<polygon.xpoints.length;i++)
            {
                polygon.ypoints[i]+=shiftY;
                polygon.xpoints[i]+=shiftX;
            }
        }
    }
    public void CreatePolygons()
    {
        for (var points : Border) {
            Polygon polygon = new Polygon();
            for (Point a : points) {
                polygon.addPoint((int)a.XY.getX(), (int)a.XY.getY());
            }
            polygons.add(polygon);
        }
    }

}
