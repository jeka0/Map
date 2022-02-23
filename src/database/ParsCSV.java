package database;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParsCSV {
    public DB db = DB.db;
    public void ReadFile(String file)
    {
        try(FileReader fr = new FileReader(file))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line = reader.readLine())!=null)
            {
               String[] lines = line.split(",");
               db.map.put(lines[0],Double.parseDouble(lines[1]));
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
