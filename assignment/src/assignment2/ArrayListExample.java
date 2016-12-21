package assignment2;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		int n=10;
		ArrayList<Integer> arrl = new ArrayList<Integer>(n);
		for(int i=1;i<=10;i++){
			arrl.add(i);//adding elements into arraylist
			System.out.println(arrl.get(i));
			
		}
		// TODO Auto-generated method stub

	}

}
