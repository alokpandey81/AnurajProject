package normalprogram;

public class ReverseStringOfSentence {

	static String funReverseStringOfSentence(String str){
		
		String strArr[]=str.split(" ");
		String strRev="";
		for(int i=0;i<strArr.length;i++){
			StringBuilder sb=new StringBuilder(strArr[i]);
			strArr[i] = sb.reverse().toString()+" ";
			System.out.println(strArr[i]);
			strRev+=strArr[i];
		}
		
		return strRev;
	}
	public static void main(String[] args) {
	
		System.out.println(funReverseStringOfSentence("Alok Kumar Pandey"));
	}

}
