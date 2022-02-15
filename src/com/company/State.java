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
}
