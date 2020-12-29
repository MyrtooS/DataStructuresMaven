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
import java.util.Arrays;
import java.util.PriorityQueue;

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
//            Nodes[] nodes = tree.toArray(new Nodes[tree.size()]);
//            Arrays.sort(nodes, tree.comparator());

            for (Nodes n : tree) {
//                FileOutputStream fos = new FileOutputStream("tree.dat");
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//                oos.writeObject(n); //writing nodes to file
//
//                oos.close();

                System.out.println(n.getCharacter() + "" + n.getFrequency() + "\n");
                System.out.println("WTF");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Huffman Tree Created");
        return file;

    }

}
