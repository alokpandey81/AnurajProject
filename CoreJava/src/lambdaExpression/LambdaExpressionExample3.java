package lambdaExpression;

interface Addition{
	
	public int add(int a, int c);
}

public class LambdaExpressionExample3 {

	public static void main(String[] args) {
		
		Addition addition =(e,f)->{
			return e+f;
		};
		System.out.println(addition.add(10,20));
		}

}
