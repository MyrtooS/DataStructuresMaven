/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.BitSet;

/**
 *
 * @author myrto
 */
public class Decoder {

    /**
     * @param args the command line arguments
     */
//    public static HashMap<Character, BitSet> huffInput = new HashMap<Character, BitSet>();
    public static ArrayList<Object> huffInput = new ArrayList<Object>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (String s : args) {
                File HuffFile = new File(args[0]);
                File ascii = new File(args[1]);

                ObjectInputStream HuffmanInput = new ObjectInputStream(new FileInputStream(HuffFile));
                Object obj = HuffmanInput.readObject();
                huffInput.add(obj);
                for(Object object : huffInput){
                    BitSet bitset = new BitSet();
                    object = (BitSet) bitset;
                    
                    
                    
                    
                
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//         FileWrapper fileWrapper = new FileWrapper();
//            File frequencies = fileWrapper.CountCharactersFile(asciiFile);
//
//            HuffmanTree huffmanTree = new HuffmanTree();
//            File tree = huffmanTree.FileToNode(frequencies);
//
//        PrintTreeCode printTreeCode = new PrintTreeCode();
//            File code = printTreeCode.treeCode(tree);

    }

}
