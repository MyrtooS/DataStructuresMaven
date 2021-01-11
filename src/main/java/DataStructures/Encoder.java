/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.HashMap;

/**
 *
 * @author 21771-21794
 */
public class Encoder {

    public static HashMap<Character, BitSet> huffcodes = new HashMap<Character, BitSet>();

    public static void Encode(File asciiFile, File codes, File output) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (output.length() != 0) {
            output.delete();
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(codes));

        Object obj = inputStream.readObject();
        huffcodes = (HashMap) obj;
        FileOutputStream fos = new FileOutputStream(output);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        BufferedReader br = new BufferedReader(new FileReader(asciiFile));
        String line;

        while ((line = br.readLine()) != null) {

            for (int i = 0; i < line.length(); i++) {

                char c = line.charAt(i);

                BitSet bitset = (huffcodes.get(c));

                
                System.out.print(bitset);

                oos.writeObject(bitset);
                oos.writeObject(-1);
            }

        }

    }

}
