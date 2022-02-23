package com.company;

import classes.Tweet;
import database.DB;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculations {
    static public DB db = DB.db;
    public static void DetermineMoodOfMessage()
    {
        for(Tweet tweet: db.Tweets)
        {
            Pattern pattern = Pattern.compile("\\w+\\s\\w+|\\w+\\-\\w+|\\w\\s\\w+\\s\\w+|\\w+");
            Matcher matcher = pattern.matcher(tweet.message);

            while (matcher.find())
            {
                String str = matcher.group();
                Double value =db.map.get(str);
                if(value!=null)tweet.mood+=value;else matcher=matcher.reset();
            }
            System.out.println(tweet.mood);
        }
    }
}
