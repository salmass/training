package assignment2;

/**import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;*/



	
		/**Enumeration id;
		String key;
		
		//creating hashtable
		
		Hashtable<Integer, String>  ht = new Hashtable<Integer, String>();		// TODO Auto-generated method stub
		ht.put(1, "geetha");
		ht.put(2, "seetha");
		ht.put(3, "chintu");
		ht.put(4, "sonu");
		ht.put(5, "kittu");
		
		for(Map.Entry m:ht.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			
		}
		
		
	}*/

	import java.util.*;
	import java.io.*;
	public class HahtableExample {
	
	
		public static void main(String[] args)throws IOException {
	{
	String str;
	Hashtable<String,Integer> stud = new Hashtable<String,Integer>();
	Enumeration<String> names;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter number of records: ");
	int n=Integer.parseInt(br.readLine());

	for (int i=1;i<=n;i++)
	{
	System.out.println("Enter Name Of "+ i+" Student");
	str=br.readLine();
	System.out.println("Enter Marks Of "+ i+"5 Student");
	int marks=Integer.parseInt(br.readLine());
	stud.put(str, marks);
	}

	int maxmarks=0;
	names = stud.keys();

	while(names.hasMoreElements())
	{
	str = (String) names.nextElement();
	System.out.println(str + ":" + stud.get(str));

	if(maxmarks<stud.get(str))
	{
	maxmarks=stud.get(str);
	}
	}
	System.out.println(" Maximum Marks Is "+maxmarks);
	}
	}
}
