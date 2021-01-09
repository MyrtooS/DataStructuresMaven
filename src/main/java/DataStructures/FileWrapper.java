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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author anna
 */
public class FileWrapper {

    private static int[] counter = new int[128];

    public FileWrapper() {

    }

    public static File writeFile() throws FileNotFoundException, IOException {

        File file = new File("frequencies.dat");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
        for (int k = 0; k < 128; k++) { // adds data from array to file frequencies.dat
            output.writeBytes(counter[k] + "\n");
          
        }

        return file;

    }
    
    public static File CountCharactersFile(File book) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(book));

        String line;

        while ((line = br.readLine()) != null) {
            
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);  // for every sentense get each character
                int AsciiValue = (int) c;  //typecast character to integer resulting in Ascii character
                
                for (int z = 0; z < 128; z++) {
                    if (AsciiValue == z) {
                        counter[AsciiValue]++;
                    }
                }

            }

        }
        File file1 = writeFile();
        return file1;
    }

}
