package normalprogram;

public class IntegerReverse {

	public static int reverseInteger(int num){
		int rev=0;
		for(int i=num;i>0;i=i/10)
		{
			rev=rev*10+(i%10);
		}
		return rev;
	}
	public static void main(String[] args) {
		System.out.println(reverseInteger(130));
	}

}
