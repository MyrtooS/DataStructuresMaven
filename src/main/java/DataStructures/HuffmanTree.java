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
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author myrto
 */
public class HuffmanTree {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());

    public static ArrayDeque<Nodes> ad = new ArrayDeque<>();
    public static ArrayDeque<Integer> ad2 = new ArrayDeque<>();

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
            nNode.character='-';
            nNode.child2 = firstNode;
            nNode.child1 = secondNode;
            //tree.add(nNode);

            root = nNode;
            tree.add(root);
        }
//       Iterator value = tree.iterator();
//
//                // Displaying the values after iterating through the queue 
//                System.out.println("The iterator values are: ");
//                while (value.hasNext()) {
//                    System.out.println(value.next().toString());
//                }
        //System.out.println(tree.peek().toString());
//        String result = findPath('a',root,"");
//        System.out.println(result);
        //System.out.println(root.toString());

      
//        FileOutputStream fos = new FileOutputStream(treeFile);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//        oos.writeObject(tree);
//
//        oos.close();
        //ad.push(root);
        //ad2.push(0);
        preorderIter(root, "");
        System.out.println("Huffman Tree Created");
        return treeFile;

    }

    public static void preorderIter(Nodes root, String s) {

        if (root == null) {
            return;
        }

        //while (ad.isEmpty()) {
        if (root.child1 == null && root.child2 == null && Character.isLetterOrDigit(root.character)) {
//            System.out.println(root.character + ":" + s);
//            Iterator value = ad2.iterator();
//
//            // Displaying the values after iterating through the queue 
//            System.out.println("The iterator values are: ");
//            while (value.hasNext()) {
//                System.out.println(value.next().toString());
//            }
            System.out.println(root.character + ":" + s);
            return;
        }

        //ad2.clear();
        preorderIter(root.child2, s + "0");
        //ad2.add(0);
        preorderIter(root.child1, s + "1");
        //ad2.add(1);

    }

}

//public static void preorderIter(Nodes root) {
//
//        if (root == null) {
//            return;
//        }
//
//        ArrayDeque<Nodes> ad = new ArrayDeque<>();
//        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
//        ad.push(root);
//        ad2.push(0);
//
//        while (!ad.isEmpty()) {
//
//            Nodes n = ad.pop();
//
//            if (n.child1 != null) {
////                ad.push(n.child1);
//                ad2.push(0);
//                preorderIter(n.child1);
//            }
//            if (n.child2 != null) {
////               ad.push(n.child2);
//                ad2.push(1);
//                preorderIter(n.child2);
//            }
//            if ((n.child1 == null) && (n.child2 == null)) {
//                Iterator value = ad2.iterator();
//
//                // Displaying the values after iterating through the queue 
//                System.out.println("The iterator values are: ");
//                while (value.hasNext()) {
//                    System.out.println("code "+value.next()+" character"+n.character);
//                }
////                System.out.println(ad2.iterator().toString());
////                
////                for (int elem : ad2) {
//////                    System.out.println(ad2.descendingIterator());
////                   
////                    System.out.println("code =" + elem  + "  character =" + n.character);
//////                    System.out.println("fsakhgjadsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
////                }
//                ad2.clear();

