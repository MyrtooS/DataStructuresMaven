/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
 
import DataStructures.*;
import java.util.Comparator;
/**
 *
 * @author myrto
 */
public class MyComparator implements Comparator<Nodes> {

    @Override
    public int compare(Nodes o1, Nodes o2) {
        if(o1.getFrequency() < o2.getFrequency()) {
				return -1;
			}
			else if(o1.getFrequency() > o2.getFrequency()) {
				return 1;
			}
			else {
				return 0;
			}
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
