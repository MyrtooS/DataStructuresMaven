/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author myrto
 */
public class HuffmanTree {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());
    //public static ArrayList<Nodes> tree = new ArrayList<Nodes>(128, new MyComparator());
//    public PriorityQueue<Nodes> getTree() {
//        return tree;
//    }
//
//    public void setTree(PriorityQueue<Nodes> tree) {
//        this.tree = tree;
//    }

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
        //System.out.println(tree.peek().toString());
        File file2 = MakeHuffmanTree();
        return file2;
    }

    public static File MakeHuffmanTree() throws IOException {
        File treeFile = new File("tree.dat");
        Nodes root = new Nodes();
        root = null;

        while (tree.size() > 1) {

            Nodes firstNode = tree.remove();
            Nodes secondNode = tree.remove();
            Nodes nNode = new Nodes();
            nNode.frequency = firstNode.getFrequency() + secondNode.getFrequency();
            nNode.child1 = firstNode;
            nNode.child2 = secondNode;
            root = nNode;
            tree.add(root);

        }
        preorderIter(root);
        FileOutputStream fos = new FileOutputStream(treeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(tree);

        oos.close();

        System.out.println("Huffman Tree Created");
        return treeFile;

    }

    public static void preorderIter(Nodes root) {

        if (root == null) {
            return;
        }

        ArrayDeque<Nodes> ad = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        ad.push(root);
//        ad2.push(0);

        while (!ad.isEmpty()) {

            Nodes n = ad.pop();
//            System.out.printf("%c ", n.character);

            if (n.child1 != null) {
                ad.push(n.child1);
                ad2.push(0);
            }
            if (n.child2 != null) {
                ad.push(n.child2);
                ad2.push(1);
            }
            if ((n.child1 == null) && (n.child2 == null)) {
                
                for (int elem : ad2) {
                    System.out.println("code =" + elem +"  character ="+n.character);
                }
                ad2.clear();
            }

        }

    }

}
