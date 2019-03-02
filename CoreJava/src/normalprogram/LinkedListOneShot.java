package normalprogram;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListOneShot {

	static int funLinkedListOneShot(LinkedList<Integer> lList){
		
		int halfSize=0,fullSize=0;
		
		Iterator<Integer> itr=lList.iterator();
		while(itr.hasNext()){
			halfSize+=2;
			if(halfSize==lList.size()/2){
				return itr.next();
				
			}
			
		}
		return 0;
	}
	public static void main(String[] args) {
		
		List<Integer> linkedList=new LinkedList<>();
		linkedList.add(23);
		linkedList.add(25);
		linkedList.add(26);
		linkedList.add(27);
		linkedList.add(28);
		
		System.out.println(linkedList);
		
		System.out.println();
	}

}
