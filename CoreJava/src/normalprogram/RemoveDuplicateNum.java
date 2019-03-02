package normalprogram;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateNum {

	static int[] funRemoveDuplicateNum(int arr[]){
		
		Set<Integer> treeSet=new LinkedHashSet<>();
		for(int i=0;i<arr.length;i++){
			treeSet.add(arr[i]);
		}
		int orgArr[]=new int[treeSet.size()];
		int j=0;
		for(int i:treeSet){
			orgArr[j]=i;
			j++;
		}
		return orgArr;
	}
	public static void main(String[] args) {
		
		int arr[]={4,5,67,3,6,4,5};
		for(int i:funRemoveDuplicateNum(arr)){
			System.out.println(i);
		}
	}

}
