/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static DataStructures.PrintTreeCode.codeFile;
import static DataStructures.PrintTreeCode.tree;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author myrto
 */
public class Encoder {

    public static HashMap<Character, BitSet> huffcodes = new HashMap<Character, BitSet>();

    public static void Encode(File asciiFile, File codes) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(codes));

        Object obj = inputStream.readObject();
        huffcodes = (HashMap) obj;

        Scanner myReader = new Scanner(asciiFile);
        String line;
        while ((line = myReader.nextLine()) != null) {
            System.out.println(line);
            for (int i = 0; i < line.length(); i++) {

                char c = line.charAt(i);
                System.out.println(huffcodes.get(c));
                DataOutputStream output = new DataOutputStream(new FileOutputStream(codes));
                output.write(huffcodes.get(c).toByteArray());
                
                

            }

        }
    }
}
