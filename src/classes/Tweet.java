package classes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {
    public Point location = new Point();
    public String date, time;
    public String message;
    public Tweet(String line)
    {
        ParsLine(line);
    }
    private void ParsLine(String line)
    {
      /*String[] strs = line.split("_");
        String[] a= strs[0].trim().split("\\[|\\]|\\,|\\s");
      for(String str:a)System.out.println(str+" "+ a.length);*/
        Pattern pattern = Pattern.compile("\\[.+\\,\\s.+\\]|\\d+\\-\\d+\\-\\d+|\\d+\\:\\d+\\:\\d+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
