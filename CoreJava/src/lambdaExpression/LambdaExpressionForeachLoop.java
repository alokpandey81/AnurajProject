package lambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionForeachLoop {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(5);
		
		arrayList.forEach((arList)->System.out.println(arList));
		
	}

}
