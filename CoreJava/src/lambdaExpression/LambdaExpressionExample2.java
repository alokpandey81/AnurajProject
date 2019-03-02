package lambdaExpression;

interface Sayable1{
	
	public void say(String s);
}
public class LambdaExpressionExample2 {

	public static void main(String[] args) {
		Sayable1 s=(name)->{
			System.out.println(name);
		};
		
		s.say("Hey Alok");
		
		Sayable1 s1=name->{
			System.out.println(name);
		};
		
		s1.say("Hey Kumar");
		
		Sayable1 s3=(String name)->{
			System.out.println(name);
		};
		
		s3.say("Hey Pandey");
	}

}
