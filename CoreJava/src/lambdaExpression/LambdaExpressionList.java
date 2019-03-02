package lambdaExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExpressionList {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();  
	       list.add("Rick");         
	       list.add("Negan");       
	       list.add("Daryl");         
	       list.add("Glenn");         
	       list.add("Carl");                
	       list.forEach(          
	           // lambda expression        
	           (names)->System.out.println(names));   
	       
	       Map<String, Integer> prices = new HashMap<>();
			prices.put("Apple", 50);
			prices.put("Orange", 20);
			prices.put("Banana", 10);
			prices.put("Grapes", 40);
			prices.put("Papaya", 50);
			
			prices.forEach((k,v)->System.out.println("Fruit: " + k + ", Price: " + v));
	       
	       
	}

}
