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
/**
 *
 * @author mnouman.bscs13seecs
 */
public class indexer implements Runnable {
    File tested;
    HashMap<String,String> Filesmap = new HashMap();
    public indexer (File filee,HashMap<String,String> Filesmapp)
    {
        tested= filee;
        Filesmap =Filesmapp;
    }
    public void run ()
    {
           // get file
        String name = tested.getName();
        String path = tested.getPath();
        //File file = new File(path);
     /*   BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
                while ((line = br.readLine()) != null) {
                         // System.out.println("The string exists in file: "+line);
                    Filesmap.put(name,line);
                }*/
        Filesmap.put(name,path);
        
    }
}
