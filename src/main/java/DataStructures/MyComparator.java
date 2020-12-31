/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
 
import java.util.Comparator;
import java.io.Serializable;
/**
 *
 * @author myrto
 */
public class MyComparator implements Serializable, Comparator<Nodes>  {

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

    }
    
}
