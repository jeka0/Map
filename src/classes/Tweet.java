package classes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {
    public Point location;
    public String date, time;
    public String message;
    public double mood;
    public Tweet(String line)
    {
        ParsLine(line);
    }
    private void ParsLine(String line)
    {
        line = line.replace("_","");
        Pattern pattern = Pattern.compile("\\[.+\\,\\s.+\\]|\\d+\\-\\d+\\-\\d+|\\d+\\:\\d+\\:\\d+|[\\@\\w\\#].+");
        Matcher matcher = pattern.matcher(line);
        ArrayList<String> strs = new ArrayList<>();
        while (matcher.find()) { strs.add(matcher.group()); }
        String[] strXY = strs.get(0).split("\\[|\\,\\s|\\]");
        location = new Point(Double.parseDouble(strXY[1]),Double.parseDouble(strXY[2]));
        date = strs.get(1);
        time = strs.get(2);
        message = strs.get(3);
    }
}
