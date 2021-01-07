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
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author 21771-21794
 */
public class PrintTreeCode {

    public static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());
    public static HashMap<Character, String> huffcodes = new HashMap<Character, String>();
    public static File codeFile = new File("code.dat");
    public static BitSet bitSet = new BitSet();

    public static File treeCode(File HuffmanFile) throws FileNotFoundException, IOException, ClassNotFoundException {

        if (codeFile.length() != 0) {
            codeFile.delete();
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(HuffmanFile));

        Object obj = inputStream.readObject();
        tree = (PriorityQueue) obj;
        Nodes root = tree.peek();
        System.out.println(tree);

        preorderIter(root, "");

        for (HashMap.Entry<Character, String> entry : huffcodes.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        return codeFile;

    }

    public static void preorderIter(Nodes root, String s) throws FileNotFoundException, IOException {

        if (root.child1 == null && root.child2 == null) {

            DataOutputStream output = new DataOutputStream(new FileOutputStream(codeFile, true));

           // System.out.println(root.character + ":" + s + "\n");
            
            
           
           

            BitSet bitset = new BitSet(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    bitset.set(i);
                }
            }
           System.out.println(bitset);
           output.writeBytes(root.character + ": " + bitset + "\n");

            //huffcodes.put(root.character, );
            return;
        }

        preorderIter(root.child2, s + "0");

        preorderIter(root.child1, s + "1");

    }

}
