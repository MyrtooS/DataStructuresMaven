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
import java.io.InputStreamReader;
import java.net.URL;
import DataStructures.*;

/**
 *
 * @author it21771 it21794
 */
public class DataStructures {
    private static  int[] counter = new int[128];
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //int[] counter = new int[128];
          for (int y = 0; y < 128; y++) { //initialises array
            counter[y] = 0;
        }
        
        URL pride = new URL("https://www.gutenberg.org/files/1342/1342-0.txt"); 
        countCharacters(pride);
        URL alice = new URL("https://www.gutenberg.org/files/11/11-0.txt");
        countCharacters(alice);
        URL moby = new URL("https://www.gutenberg.org/files/2701/2701-0.txt");
        countCharacters(moby);
        File file=ReadFile();
        HuffmanTree.FileToNode(file);
        
       
        
    }
    public static File ReadFile() throws FileNotFoundException, IOException{
        
        
        File file = new File("frequencies.dat");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        for (int k = 0; k < 128; k++) { // adds data from array to file frequencies.dat
            output.writeBytes( counter[k] + "\n");
            //output.writeBytes(k + ": " + counter[k] + "\n"); 
        }

        BufferedReader br = new BufferedReader(new FileReader("frequencies.dat"));
        String line1;
        while ((line1 = br.readLine()) != null) { //prints results
            System.out.println(line1);
        }
         return file;
    
    }
    /**
     *
     * @param book
     * @throws IOException
     */
    public static void countCharacters(URL book) throws IOException{
        
      BufferedReader in = new BufferedReader( new InputStreamReader(book.openStream()));
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
    }
    

}
