package assignment2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>(); // creating hashmap
		 
		//inserting elements to the map
		hm.put(1, "salma");
		hm.put(2, "subbu");
	    hm.put(3, "phani");
	    hm.put(4, "amulya");
	    hm.put(5, "mounika");
	    
	    // displaying using iterator
	    Set set = hm.entrySet();
	    Iterator it = set.iterator();
	    while(it.hasNext()){
	    	Map.Entry me = (Map.Entry)it.next();
	    	System.out.println("employee id: ;"+ me.getKey()+ " Name: "+ me.getValue());
	    	
	    }
	    
	   
		
		// TODO Auto-generated method stub

	}

}
