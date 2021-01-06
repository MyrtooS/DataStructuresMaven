/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static DataStructures.HuffmanTree.ad2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author 21771-21794
 */
public class PrintTreeCode {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());

    public static File codeFile = new File("code.dat");

    public static File treeCode(File HuffmanFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        File codeFile = new File("code.dat");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(HuffmanFile));

        Object obj = inputStream.readObject();
        tree = (PriorityQueue) obj;
        Nodes root = tree.peek();
        System.out.println(tree);

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        preorderIter(root, "");
        return codeFile;

    }

    public static void preorderIter(Nodes root, String s) throws FileNotFoundException, IOException {

        if (root.child1 == null && root.child2 == null) {

            DataOutputStream output = new DataOutputStream(new FileOutputStream(codeFile));
//            System.out.println("The iterator values " + root.character + " are: " + "\n");
           System.out.println( root.character + ":" + s + "\n");

//            for (int i = 0; i < ad2.size(); i++) {
//                System.out.print(ad2.toArray()[i]);
//
//            }

            return;
        }
        
        preorderIter(root.child2, s+"0");
        preorderIter(root.child1, s+"1");
//        if (root.child2 != null) {
//            ad2.add("0");
//            preorderIter(root.child2, ad2);
//        }
//        if (root.child1 != null) {
//
//            ad2.add("1");
//            preorderIter(root.child1, ad2);
//        }
//        ad2.clear();

    }

}
