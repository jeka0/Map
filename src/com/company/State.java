package com.company;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class State {
    public State(){}
    public State(String Name,LinkedList<LinkedList<Point>> Border){this.Name = Name; this.Border = Border;}
    public String Name;
    public LinkedList<LinkedList<Point>> Border = new LinkedList<>();
    public void Increase(double num)
    {
        for(LinkedList<Point> List:Border)
        {
            for(Point point: List)
            {
                point.newXY.x=(int) Math.round(point.newXY.getX()*num);
                point.newXY.y=(int) Math.round(point.newXY.getY()*num);
            }
        }
    }
    public void Shift(int shiftY,int shiftX)
    {
        for(LinkedList<Point> List:Border)
        {
            for(Point point: List)
            {
                point.newXY.y+=shiftY;
                point.newXY.x+=shiftX;
            }
        }
    }

}
