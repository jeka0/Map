package classes;
import JMPL.*;

import java.awt.geom.Point2D;

public class Point {
    public Point(){}
    public Point(double x,double y){TranslateCoordinates(x,y);}
    public Point2D.Double XY;
    public void TranslateCoordinates(double x , double y)
    {
        MercatorProjection projection = new MercatorProjection();
        double latitude = x;
        double longitude = y;

        // convert to radian
        latitude = latitude * Math.PI / 180;
        longitude = longitude * Math.PI / 180;

        Point2D.Double d = projection.project(longitude, latitude, new Point2D.Double());
        d.y=-(d.y-2);
        int magnifiedX = (int) Math.round((3.5+d.x)*430);
        int magnifiedY = (int) Math.round(d.y*430);
        XY = new Point2D.Double(magnifiedX, magnifiedY);
    }
}
