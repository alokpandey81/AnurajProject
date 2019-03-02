package generics;

import java.util.ArrayList;
import java.util.List;

class Employee{
	
}
public class GenericsTest1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(20);
		
		
		//fun(list); // Error
		
	}
	
	static void fun(List<Object> list){
		
	}

}
