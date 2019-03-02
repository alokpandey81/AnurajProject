package normalprogram;

public class PrimeNum {

	static boolean isPrimeNo(int num){
		
		if(num==2)return true;
		if(num%2==0)return false;
		for(int i=3;i<num/2;i+=2){
			if(num%i==0)return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPrimeNo(2));
		System.out.println(isPrimeNo(8));
		System.out.println(isPrimeNo(31));
		System.out.println(isPrimeNo(71));

	}

}
