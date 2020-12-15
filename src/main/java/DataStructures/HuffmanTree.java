/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import DataStructures.Nodes;
import java.util.PriorityQueue;

/**
 *
 * @author myrto
 */
public class HuffmanTree {
    
    public PriorityQueue<Nodes> tree = new PriorityQueue<Nodes>();

    public PriorityQueue<Nodes> getTree() {
        return tree;
    }

    public void setTree(PriorityQueue<Nodes> tree) {
        this.tree = tree;
    }

    public HuffmanTree() {
    }
    
    
    
    
    
    
}

