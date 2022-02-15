package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class JsonPars {
    private JSONObject jsonObject;
    public LinkedList<State> States = new LinkedList<>();
    private State state, oldState;
    private LinkedList<Point> nowPoints;
    private boolean NotNew = false;
    JsonPars(final String filePath)
    {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
    public void ReadFile()
    {
            jsonObject.forEach((key,value)->{state = new State();state.Name = key.toString();//System.out.println(key);
            CheckArray((JSONArray)value);
            state.Border.add(nowPoints);
            nowPoints = null;
            States.add(state);
        });
    }
    public void CheckArray(JSONArray array)
    {
        boolean flag = false;
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i) instanceof JSONArray)
            {
                if(!NotNew && ((JSONArray)array.get(i)).size() !=2)
                {
                    if(nowPoints!=null){state.Border.add(nowPoints);}
                    nowPoints = new LinkedList<>();NotNew=true;
                }
                CheckArray((JSONArray)array.get(i));
            }else flag= true;
        }
        if(flag){
            NotNew = false;
            String strX = array.get(0).toString(), strY = array.get(1).toString();
            nowPoints.add(new Point(Double.parseDouble(strX),Double.parseDouble(strY)));
        }
    }



}

