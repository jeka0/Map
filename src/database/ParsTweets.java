package database;

import classes.Tweet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParsTweets {
    public DB db = DB.db;
    public void ReadFile(String file)
    {
        try(FileReader fr = new FileReader(file))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line = reader.readLine())!=null)
            {
               db.Tweets.add(new Tweet(line));
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
