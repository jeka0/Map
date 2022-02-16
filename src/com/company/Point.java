package com.company;
import JMPL.*;

import java.awt.geom.Point2D;

public class Point {
    public Point(){};
    public Point(double x,double y){this.x =x; this.y=y;TranslateCoordinates();}
    public double x;
    public double y;
    Point2D.Double newXY;
    public void TranslateCoordinates()
    {
        MercatorProjection projection = new MercatorProjection();
        double latitude = y;
        double longitude = x;

        // convert to radian
        latitude = latitude * Math.PI / 180;
        longitude = longitude * Math.PI / 180;

        Point2D.Double d = projection.project(longitude, latitude, new Point2D.Double());
        d.y=-(d.y-2);
        int magnifiedX = (int) Math.round((3.5+d.x)*430);
        int magnifiedY = (int) Math.round(d.y*430);
        newXY = new Point2D.Double(magnifiedX, magnifiedY);
    }
}
