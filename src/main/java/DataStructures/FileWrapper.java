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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author anna
 */
public class FileWrapper {
    private static int[] counter = new int[128];
    
    public FileWrapper() {
    
    }
    public static File returnFile() throws IOException{
        readUrl();
        File file=ReadFile();
        return file;
    }
    public static void readUrl() throws MalformedURLException, IOException {
        URL pride = new URL("https://www.gutenberg.org/files/1342/1342-0.txt");
        countCharacters(pride);
        URL alice = new URL("https://www.gutenberg.org/files/11/11-0.txt");
        countCharacters(alice);
        URL moby = new URL("https://www.gutenberg.org/files/2701/2701-0.txt");
        countCharacters(moby);
        
        
    }
   
    public static File ReadFile() throws FileNotFoundException, IOException {

        File file = new File("frequencies.dat");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        for (int k = 0; k < 128; k++) { // adds data from array to file frequencies.dat
            output.writeBytes(counter[k] + "\n");
            //output.writeBytes(k + ": " + counter[k] + "\n"); 
        }

        BufferedReader br = new BufferedReader(new java.io.FileReader("frequencies.dat"));
        String line1;
        while ((line1 = br.readLine()) != null) { //prints results
            System.out.println(line1);
        }
        return file;

    }

    public static void countCharacters(URL book) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(book.openStream()));
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
