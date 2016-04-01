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
public class crawler implements Runnable{
    File file;
    HashMap<String,String> Filesmap = new HashMap();
    Collection<File> FilesArray;
    public crawler(File filee, Collection<File> arr,HashMap<String,String> Filesmapp){
		file = filee;
                FilesArray= arr;
                Filesmap=Filesmapp;
                
	}
	
    
    
    public void run ()
    {
        ///System.out.println("ahhaah");
        File[] subfiles = file.listFiles();
        if (subfiles == null) {
          //  System.out.println(" yaha sy koi sub diretory ni ha\n"+file+"\nend\n");
             FilesArray.add(file);
             Thread indexerThread = new Thread(new indexer(file,Filesmap));
                indexerThread.start();
        }
        else
        {
           for (File current : subfiles) {
                //System.out.println(" hey  "+current);
                Thread newThread = new Thread(new crawler(current,FilesArray,Filesmap));
                newThread.start();
            }
        }
    }
            
}
