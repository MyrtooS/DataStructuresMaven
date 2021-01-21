/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static DataStructures.Encoder.huffcodes;
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
import DataStructures.*;

/**
 *
 * @author myrto
 */
public class Encoder_Main {

    /**
     * @param args the command line arguments
     */
    public static HashMap<Character, BitSet> huffcodes = new HashMap<Character, BitSet>();

    public static void main(String[] args) {
        // TODO code application logic here

        for (String s : args) {
            File asciiFile = new File(args[0]);
            File output = new File(args[1]);
            File codes = new File(args[2]);
            try {
                File encodedFile = new File("output.dat");
                encodedFile =  Encoder.Encode(asciiFile, codes, output);
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
