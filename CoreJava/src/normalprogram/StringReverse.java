package normalprogram;

public class StringReverse {

	public static String reverseString(String str){  
	    char ch[]=str.toCharArray();  
	    String rev="";  
	    for(int i=ch.length-1;i>=0;i--){  
	        rev+=ch[i];  
	    }  
	    return rev;  
	} 
	public static String reverseString1(String str){
		String strrev="";
		for(int i=str.length()-1;i>=0;i--){
			strrev+=str.charAt(i);
		}
		return strrev;
	}
	public static void main(String[] args) {
		System.out.println(reverseString("Alok"));
		System.out.println(reverseString1("Alok"));

	}

}
