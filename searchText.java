/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mnouman.bscs13seecs
 */
public class searchText implements Runnable{
    String s;
    String val;
    public searchText(String path, String word)
    {
        val =path;
        s=word;
    }
    
    public void run()
    {
        BufferedReader br = null;
        try {
            String line = null;
            File file = new File(val);
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            while (line != null )
            {
                if(line.contains(s)){
                    System.out.println("The string is in:   "+val);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(searchText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(searchText.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(searchText.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
