package hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PhoneBill {

	 public static int solution(String S) {
		 
		 String S1[]=new String[S.length()/20];
		 for(int i=0,k=0;i<S.length();i+=20,k++){
			 S1[k]=S.substring(i, i+20);
		 }
		 Map<String,Integer> phoneMap= new ConcurrentHashMap<>();
		 for(int i=0;i<S1.length;i++){
			 for(int j=0;j<S1[i].length();j+=20){
				 Integer hrVal= new Integer(S1[i].substring(0,2));
				 Integer mnVal= new Integer(S1[i].substring(3,5));
				 Integer ssVal = new Integer(S1[i].substring(6,8));
				 
				 if(phoneMap.containsKey(S1[i].substring(9, 20))){
					 
					 Integer totalVal =phoneMap.get(S1[i].substring(9, 20));
					 phoneMap.put(S1[i].substring(9, 20), (totalVal+(hrVal*60*60)+(mnVal*60)+(ssVal)));
				 	}
				 else{
					 phoneMap.put(S1[i].substring(9, 20), ((hrVal*60*60)+(mnVal*60)+(ssVal)));
				 }
				 }
			 }
		 Iterator<Map.Entry<String,Integer>> itr=phoneMap.entrySet().iterator();
		 
		 int maxVal=0;String maxKey="";
		 while(itr.hasNext()){
			 /*if(maxVal==0){
				 maxVal = itr.next().getValue();
				 maxKey = itr.next().getKey();
				 
			 }*/
			// System.out.println(maxVal);
			 Map.Entry<String,Integer> entry= itr.next();
			 System.out.println(entry.getValue());
			 if( maxVal<entry.getValue()){
				// System.out.println("inside if"+entry.getValue());
				 maxVal = entry.getValue();
				 maxKey = entry.getKey();
			 }
		 }
		 phoneMap.remove(maxKey);
		 
		 Iterator<Map.Entry<String,Integer>> itr1=phoneMap.entrySet().iterator();
		 int totalCent=0;
		 while(itr1.hasNext()){
			 Map.Entry<String,Integer> entry= itr.next();
			 if(entry.getValue()>=300 ){
				 totalCent = totalCent + (entry.getValue()/60)*5;
			 }else{
				 totalCent = totalCent + (entry.getValue()*3);
			 }
		 }
		 
	/*	 System.out.println(phoneMap.get("400-234-090"));
		 System.out.println(phoneMap.get("701-080-080"));*/
		 
		 System.out.println(totalCent);
		 return totalCent;
	 }
	
	public static void main(String[] args) {
		
		String S="00:01:07,400-234-090"
				+"00:05:01,701-080-080"
				+"00:05:00,400-234-090";
				  
		
		System.out.println(solution(S));
	}

}
