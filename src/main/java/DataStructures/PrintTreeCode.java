/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.EOFException;
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

    public static PriorityQueue<Nodes> pq = new PriorityQueue<Nodes>(128, new MyComparator());

    public static File treeCode(File HuffmanFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        File codeFile = new File("code.dat");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(HuffmanFile));

        Object obj = inputStream.readObject();
        System.out.println(obj);
        try {

            //System.out.println(obj);

        } catch (Exception e) {
            System.out.println("\n" + "End of file reached");
        }

        return codeFile;
    }

}
