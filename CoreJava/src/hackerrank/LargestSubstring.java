package hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LargestSubstring {
	
	
	static int substringFun1(int len,String s){
		if(s==null||s.length()==0){
	        return 0;
	    }
	    int result = 0;
	    int k=0;
	    HashSet<Character> set = new HashSet<Character>();
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(!set.contains(c)){
	            set.add(c);
	            result = Math.max(result, set.size());
	        }else{
	            while(k<i){
	                if(s.charAt(k)==c){
	                    k++;
	                    break;
	                }else{
	                    set.remove(s.charAt(k));
	                    k++;
	                }
	            }
	        }  
	    }
	    return result;
	}
	static int substringFun(int len, String s){
		char []ch=s.toCharArray();
		System.out.println(ch);
		Map<Character,Integer> hmap=new HashMap<>();
		for(int i=0;i<len;i++){
			if(hmap.containsKey(ch[i])){
				hmap.put(ch[i], (hmap.get(ch[i]))+1);
			}else{
				hmap.put(ch[i], 1);
			}
		}
		System.out.println(hmap);
		if(hmap.get('0')==hmap.get('1'))return hmap.get('0');
		else return hmap.get('0')>hmap.get('1')?hmap.get('0'):hmap.get('1');
	}

	public static void main(String[] args) {
		System.out.println(substringFun(7,"0011101"));
		System.out.println(substringFun1(7,"00011100011"));

	}

}
