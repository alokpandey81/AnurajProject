package normalprogram;

public class Swap2Var {

	public static void main(String[] args) {
		int a=50,b=20;
		
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("a="+a+"b="+b);
	}

}
