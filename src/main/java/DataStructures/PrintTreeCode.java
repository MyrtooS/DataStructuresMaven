/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author 21771-21794
 */
public class PrintTreeCode {

    private static PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>(128, new MyComparator());
    private static HashMap<Character, BitSet> huffcodes = new HashMap<Character, BitSet>();
    private static HashMap<BitSet, Character> huffcodesRewind = new HashMap<BitSet, Character>();
    private static File codeFile = new File("code.dat");
    private static File codeFile2 = new File("code2s.dat");
    private static BitSet bitSet = new BitSet();

    public static File treeCode(File HuffmanFile) throws FileNotFoundException, IOException, ClassNotFoundException {

        if (codeFile.length() != 0) {
            codeFile.delete();
        }

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(HuffmanFile));
        Object obj = inputStream.readObject();

        tree = (PriorityQueue) obj;
        Nodes root = tree.peek();

        preorderIter(root, "");

        return codeFile;

    }
    public static File returnFile2(){
        return codeFile2 ;
    }

    public static void preorderIter(Nodes root, String s) throws FileNotFoundException, IOException {

        if (root.child1 == null && root.child2 == null) {

            FileOutputStream fos = new FileOutputStream(codeFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileOutputStream fos2 = new FileOutputStream(codeFile2);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

            BitSet bitset = new BitSet(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    bitset.set(i);
                }
            }

            
            huffcodes.put(root.character, bitset);
            oos.writeObject(huffcodes);
            
            huffcodesRewind.put(bitset, root.character);
            oos2.writeObject(huffcodesRewind);

            return;
        }

        preorderIter(root.child2, s + "0");

        preorderIter(root.child1, s + "1");

    }

}
