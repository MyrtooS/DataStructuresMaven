/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 *
 * @author myrto
 */
public class HuffmanTree {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());

    public static ArrayDeque<Nodes> ad = new ArrayDeque<>();
    public static ArrayDeque<String> ad2 = new ArrayDeque<>();

    public PriorityQueue<Nodes> getTree() {
        return tree;
    }

    public void setTree(PriorityQueue<Nodes> tree) {
        this.tree = tree;
    }

    public static File FileToNode(File file) throws FileNotFoundException, IOException {

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

        File file2 = MakeHuffmanTree();
        return file2;
    }

    public static File MakeHuffmanTree() throws IOException {
        File treeFile = new File("tree.dat");
        Nodes root = null;

        while (tree.size() > 1) {

            Nodes firstNode = tree.remove();
            Nodes secondNode = tree.remove();
            Nodes nNode = new Nodes();
            nNode.frequency = firstNode.getFrequency() + secondNode.getFrequency();
            nNode.character = '-';
            nNode.child2 = firstNode;
            nNode.child1 = secondNode;
            //tree.add(nNode);

            root = nNode;
            tree.add(root);
        }

        FileOutputStream fos = new FileOutputStream(treeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(tree);

        oos.close();
       
       
        //System.out.println("Huffman Tree Created");
        return treeFile;

    }

   

}
