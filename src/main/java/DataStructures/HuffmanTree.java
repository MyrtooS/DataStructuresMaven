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
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author myrto
 */
public class HuffmanTree {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());

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
        MakeHuffmanTree();
    }

    public static File MakeHuffmanTree() {
        File file = new File("tree.dat");
        Nodes root = new Nodes();
        root = null;
        while (tree.size() > 1) {

            Nodes firstNode = tree.peek();
            tree.poll();
            Nodes secondNode = tree.peek();
            tree.poll();
            Nodes nNode = new Nodes();
            int total = firstNode.getFrequency() + secondNode.getFrequency();
            nNode.setFrequency(total);
            nNode.setChild1(firstNode);
            nNode.setChild2(secondNode);
            root = nNode;
            tree.add(root);

        }
        try {
            Nodes[] nodes = tree.toArray(new Nodes[tree.size()]);
            Arrays.sort(nodes, tree.comparator());

            for (Nodes n : nodes) {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream output = new ObjectOutputStream(fos);
                output.writeUnshared(n);
            }
            
        } catch (Exception e) {

        }
        return file;

    }

}
