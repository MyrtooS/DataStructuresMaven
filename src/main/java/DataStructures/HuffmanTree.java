/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import DataStructures.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

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

    public static void FileToNode(File file) throws FileNotFoundException, IOException {

        int AsciiValue;
        int counter = 0;
        DataInputStream input = new DataInputStream(new FileInputStream(file));
        String line1;
        while ((line1 = input.readLine()) != null) {
            AsciiValue = Integer.parseInt(line1);

            Nodes node = new Nodes();
            node.setCharacter((char) counter);
            node.setFrequency(AsciiValue);
            node.setChild1(null);
            node.setChild2(null);

            tree.add(node);

            counter++;
            

        }
        MakeHuffmanTree(tree);
    }

    public static File MakeHuffmanTree(PriorityQueue q) {
        File file = new File("tree.dat");

        while (q.isEmpty() == false) {

            //q.poll();
            //q
            Nodes firstNode = (Nodes) q.peek();
            q.poll();
            Nodes secondNode = (Nodes) q.peek();
            q.poll();

        }
        return file;

    }

}
