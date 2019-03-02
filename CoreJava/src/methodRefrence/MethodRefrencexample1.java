package methodRefrence;

@FunctionalInterface 
interface MyInterface{  
    void display();  
}  
public class MethodRefrencexample1 {

    public void myMethod(){  
	System.out.println("Instance Method");  
    }  
    public static void main(String[] args) {  
    	MethodRefrencexample1 obj = new MethodRefrencexample1();   
	// Method reference using the object of the class
	MyInterface ref = obj::myMethod;  
	// Calling the method of functional interface  
	ref.display();  
    }  
}

