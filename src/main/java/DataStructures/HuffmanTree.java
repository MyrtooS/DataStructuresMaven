/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import DataStructures.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 *
 * @author myrto
 */
public class HuffmanTree {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>();

    public PriorityQueue<Nodes> getTree() {
        return tree;
    }

    public void setTree(PriorityQueue<Nodes> tree) {
        this.tree = tree;
    }

    public static void FileToNode() {
        try {
            int AsciiValue;
            int counter = 0;
            BufferedReader br = new BufferedReader(new FileReader(DataStructures.ReadFile()));
            String line1;
            while ((line1 = br.readLine()) != null) {
                AsciiValue = Integer.parseInt(line1);

                System.out.print(AsciiValue + "\n");
              
               Nodes node=new Nodes();
               node.setCharacter((char) counter);
               node.setFrequency(AsciiValue);
               tree.add(node);
               
               counter++;
               
                //    }
            }
        } catch (Exception e) {
            System.out.println("An Exception Occured");
        }

    }

}
