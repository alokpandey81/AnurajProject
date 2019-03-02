package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Romanizer {

	public static void main(String[] args) {
		List<Integer> iList = Arrays.asList(5,1,2,3,4,5);
		List<Integer> iList1 = Arrays.asList(5,75,80,99,100,50);
		
		System.out.println(romanizer(iList));
		System.out.println(romanizer(iList1));
	}

	public static List<String> romanizer(List<Integer> numbers) {
	    // Write your code here
	    List<String> strList = new ArrayList<String>();
	    int[] primitive = numbers.stream()
	                            .mapToInt(Integer::intValue)
	                            .toArray();
	   
	        for(int i=1;i<=primitive[0];i++){
	            strList.add(convertToRoman(primitive[i]));
	            //System.out.println(convertToRoman(primitive[i]));
	        }

	        return strList;
	    }
	
	static String convertToRoman(int val){                
        String res=""; 
        String huns[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};         
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};         
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};                 
        int   size[] = { 0,   1,    2,     3,    2,   1,  2,      3,       4,     2};     

        while (val >= 1000) {
           res=res+'M';
           val -= 1000;
    }
     
    res=res+huns[val/100];
    val = val % 100;
     
        res=res+ tens[val/10];  
    val = val % 10;
     
        res=res+ ones[val];
    return res;
  }
}
