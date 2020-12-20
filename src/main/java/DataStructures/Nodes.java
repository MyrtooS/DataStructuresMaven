/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.Serializable;

/**
 *
 * @author myrto
 */
public class Nodes implements Serializable {

    int frequency;
    char character;
    Nodes child1;
    Nodes child2;

    public Nodes(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
    }

    public Nodes() {

    }

    public Nodes(int frequency, Nodes child1, Nodes child2) {
        this.frequency = frequency;
        this.child1 = child1;
        this.child2 = child2;
    }
    
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Nodes getChild1() {
        return child1;
    }

    public void setChild1(Nodes child1) {
        this.child1 = child1;
    }

    public Nodes getChild2() {
        return child2;
    }

    public void setChild2(Nodes child2) {
        this.child2 = child2;
    }

//    @Override
//    public int compareTo(Nodes o) {
//        return Integer.compare(this.getFrequency(), o.getFrequency());
//        
//        //throw new UnsupportedOperationException("Not supported yet.");
//
////        Nodes node1 = new Nodes();
////        Nodes node2 = new Nodes();
////        if (node1.getFrequency() < node2.getFrequency()) {
////            
////            return -1;
////        }
////         if (node1.getFrequency() > node2.getFrequency()) {
////            
////            return 1;
////        }
////        return 0;
//    }

}
