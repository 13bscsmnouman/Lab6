/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider;

import java.io.*;
import java.util.*;

/**
 *
 * @author mnouman.bscs13seecs
 */
public class Spider {

    public static void printIndex(HashMap MyFiles) {
        System.out.println("hello");
        Set st = MyFiles.entrySet();
        Iterator itr = st.iterator();
        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();
            System.out.print(me.getKey() + ": \n" + me.getValue());
        }

    }

    public static void searchText(HashMap Filesmap) throws IOException {

        System.out.println("Enter text you want to find : ");
        //for user input
        Scanner scanf = new Scanner(System.in);
        String s = scanf.nextLine();

        Set set = Filesmap.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();
            String val = (String) me.getValue();
            //System.out.println("Val is:   "+val);
            Thread someThread = new Thread(new searchText(val, s));
            someThread.start();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Collection<File> FilesArray = new ArrayList<File>();
        HashMap<String, String> Filesmap = new HashMap();
        try {
            String rootPath = "E:\\New folder";
            //TraverseDirectory(new File(rootPath), FilesArray);
            long startTime = System.nanoTime();
            Thread someThread = new Thread(new crawler(new File(rootPath), FilesArray, Filesmap));
            someThread.start();
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                //Handle exception
            }

            printIndex(Filesmap);
            searchText(Filesmap);
        } catch (IOException ex) {
        }
    }
}
