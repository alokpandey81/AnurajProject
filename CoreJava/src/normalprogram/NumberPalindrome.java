package normalprogram;

public class NumberPalindrome {

	static boolean funNumberPalindrom(int num){
		String s=new Integer(num).toString();
		for(int i=0;i<(s.length()/2)+1;i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(funNumberPalindrom(123));
		System.out.println(funNumberPalindrom(12321));
		System.out.println(funNumberPalindrom(123321));
	}

}
