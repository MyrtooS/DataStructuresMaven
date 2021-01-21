/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static DataStructures.Encoder.huffcodes;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    public static HashMap<BitSet, Character> huffcodes = new HashMap<BitSet, Character>();

    public static File Decoder(File HuffFile, File Ascii, File huffmanMap) {
        try {

            ObjectInputStream MapInput = new ObjectInputStream(new FileInputStream(huffmanMap));
            Object obj = MapInput.readObject();
            huffcodes = (HashMap) obj;

            ObjectInputStream HuffmanInput = new ObjectInputStream(new FileInputStream(HuffFile));
            //while(MapInput.available()<0){
            while ((obj = HuffmanInput.readObject()) != null) {
              
                BitSet bitset = (BitSet) obj;
                
                
                    char c = huffcodes.get(bitset);
                    System.out.print(c);
                    DataOutputStream output = new DataOutputStream(new FileOutputStream(Ascii));
                    output.write(c);
                 
                
            }
         //   }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Ascii;
    }

}
