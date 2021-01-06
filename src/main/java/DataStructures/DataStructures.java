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

        FileWrapper fileReader = new FileWrapper();
        File file = fileReader.returnFile();
        File file2;
        file2=HuffmanTree.FileToNode(file);
        PrintTreeCode pt = new PrintTreeCode();
        File file1=pt.treeCode(file2);
        
        
        

    }

}
