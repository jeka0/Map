package com.company;


public class Point {
    public Point(){};
    public Point(double x,double y){this.x =x; this.y=y;TranslateCoordinates();}
    public double x;
    public double y;
    private static final int    EARTH_RADIUS    = 6371;
    private static final double FOCAL_LENGTH    = 500;
    private static final int    IMAGE_PADDING   = 50;
    public int newX;
    public int newY;
    public void TranslateCoordinates()
    {
        double latitude = y;
        double longitude = x;

        // convert to radian
        latitude = latitude * Math.PI / 180;
        longitude = longitude * Math.PI / 180;

        double x = EARTH_RADIUS * Math.sin(latitude) * Math.cos(longitude);
        double y = EARTH_RADIUS * Math.sin(latitude) * Math.sin(longitude);
        double z = EARTH_RADIUS * Math.cos(latitude);

        double projectedX = x * FOCAL_LENGTH / (FOCAL_LENGTH + z);
        double projectedY = y * FOCAL_LENGTH / (FOCAL_LENGTH + z);

        // scale the map bigger
        newX = (int) Math.round(projectedX+1200);
        newY = (int) Math.round(projectedY+700);
    }
}
