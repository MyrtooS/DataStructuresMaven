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

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        for (String s : args) {
            File asciiFile = new File(args[0]);
            File outputFile = new File(args[1]);

            FileWrapper fileWrapper = new FileWrapper();
            File frequencies = fileWrapper.CountCharactersFile(asciiFile);

            HuffmanTree huffmanTree = new HuffmanTree();
            File tree = huffmanTree.FileToNode(frequencies);

            PrintTreeCode printTreeCode = new PrintTreeCode();
            File code = printTreeCode.treeCode(tree);
            File code2 = printTreeCode.returnFile2();

            Encoder encoder = new Encoder();
            File output = new File("output2");
            File output2 = encoder.Encode(asciiFile, code, output);

            Decoder decoder = new Decoder();

            decoder.Decoder(output2, outputFile, code2);
        }

    }

}
