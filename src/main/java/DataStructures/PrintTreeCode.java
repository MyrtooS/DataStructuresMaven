/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author 21771-21794
 */
public class PrintTreeCode {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());

    public static File treeCode(File HuffmanFile) throws FileNotFoundException, IOException, ClassNotFoundException {
//        BufferedReader br = new BufferedReader(new java.io.FileReader(HuffmanFile));
//        String line;
//        while ((line = br.readLine()) != null) {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("tree.dat"));
//
//            Object obj = null;
//
//            while ((obj = inputStream.readObject()) != null) {
//
//            System.out.println(obj.toString());
//        }

        FileInputStream fis = new FileInputStream(HuffmanFile);
        ArrayList<Object> objectsList = new ArrayList<>();
        
        boolean cont = true;
        while (cont) {
            ObjectInputStream input = new ObjectInputStream(fis) ;
//  try (ObjectInputStream input = new ObjectInputStream(fis)) {
            Object obj = input.readObject();
            if (obj != null) {
                objectsList.add(obj);
                
                 System.out.println("ff");
            } else {
                cont = false;
            }
          //  } catch (Exception e) {
            // System.out.println(e.printStackTrace());
            // }
        }
//        ObjectInputStream input = new ObjectInputStream(fis) ;
//        Object obj = input.readObject();
//        while (obj!= null) { 
//            objectsList.add(obj);
//            System.out.println("ff");
//            
//        }

        File file = new File("code.dat");

        return file;
    }
}
