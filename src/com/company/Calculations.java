package com.company;

import classes.Point;
import classes.Tweet;
import classes.State;
import database.DB;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculations {
    static public DB db = DB.db;
    public static void DetermineMoodOfMessage()
    {
        Pattern pattern1 = Pattern.compile("\\w+\\-\\w+|\\w\\s[\\w\\']+\\s[\\w\\']+|[\\w\\']+\\s[\\w\\']+|[\\w\\']+");
        Pattern pattern2 = Pattern.compile("[\\w\\']+");
        for(Tweet tweet: db.Tweets)
        {
            Matcher matcher1 = pattern1.matcher(tweet.message);
            Matcher matcher2 = pattern2.matcher(tweet.message);
            Matcher matcher = matcher1;
            int start = 0;
            while (matcher.find(start))
            {
                String str = matcher.group().toLowerCase();
                Double value =db.map.get(str);
                if(value!=null){tweet.mood+=value;start=matcher.end();matcher =matcher1;}else
                {
                    if(matcher.equals(matcher2)){start=matcher.end();matcher = matcher1;}else matcher = matcher2;
                }
            }
        }
    }
    public static void CreatePolygons()
    {
        for(State state:db.States)
        {
            state.CreatePolygons();
        }
    }
    public static void DetermineMoodOfState()
    {
        for(State state: db.States)
        {
            for(Polygon polygon: state.polygons)
            {
                for(Tweet tweet:db.Tweets) {
                    if (polygon.contains(tweet.location.XY)) state.mood += tweet.mood;
                }
            }
            System.out.println(state.Name + " " + state.mood);
        }
    }
}
