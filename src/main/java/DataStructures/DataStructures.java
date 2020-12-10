/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author it21771 it21794
 */
public class DataStructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        int[] counter = new int[128];

        for (int y = 0; y < 128; y++) { //initialises array
            counter[y] = 0;
        }

        File input = new File("/home/anna/characteroutput.txt"); //characteroutput.txt contains all three books, unique path for every user.

        BufferedReader in = new BufferedReader(new FileReader(input));

        String line;
        while ((line = in.readLine()) != null) {
            //System.out.println(line);
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);  // for every sentense get each character
                int AsciiValue = (int) c;  //typecast character to integer resulting in Ascii character
                //System.out.println(AsciiValue);
                for (int z = 0; z < 128; z++) {
                    if (AsciiValue == z) {
                        counter[AsciiValue]++;
                    }
                }

            }

        }
        in.close();

        File file = new File("frequencies.dat");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        for (int k = 0; k < 128; k++) { // adds data from array to file frequencies.dat
            output.writeBytes((char) k + ": " + counter[k] + "\n");
            //output.writeBytes(k + ": " + counter[k] + "\n"); 
        }

        BufferedReader br = new BufferedReader(new FileReader("frequencies.dat"));
        String line1;
        while ((line1 = br.readLine()) != null) { //prints results
            System.out.println(line1);
        }
    }

}
