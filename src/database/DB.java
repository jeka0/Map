package database;

import classes.State;
import classes.Tweet;

import java.util.LinkedList;

public class DB {
    public static DB db;
    public LinkedList<State> States = new LinkedList<>();
    public LinkedList<Tweet> Tweets = new LinkedList<>();
    public DB(){db=this;}
}
