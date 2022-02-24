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
            Pattern pattern1 = Pattern.compile("\\w+\\-\\w+|\\s\\w\\s\\w+\\s\\w+\\s|\\s\\w+\\s\\w+\\s|\\w+");
            Pattern pattern2 = Pattern.compile("\\w+");
            Matcher matcher1 = pattern1.matcher(tweet.message);
            Matcher matcher2 = pattern2.matcher(tweet.message);
            Matcher matcher = matcher1;
            int start = 0;
            while (matcher.find(start))
            {
                String str = matcher.group();
                Double value =db.map.get(str);
                if(value!=null){tweet.mood+=value;start=matcher.end();matcher =matcher1;}else
                {
                    if(matcher.equals(matcher2)){start=matcher.end();matcher = matcher1;}else matcher = matcher2;
                }
            }
            System.out.println(tweet.mood);
        }
    }
}
