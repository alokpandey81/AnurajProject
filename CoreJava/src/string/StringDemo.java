package string;

public class StringDemo {

	public static void main(String[] args) {
		
		String s= "Alok";
		String s2= "Alok";
		s2.concat("Pa");
		
		System.out.println(s +" "+s.hashCode());
		System.out.println(s2 +" "+s2.hashCode());
		
		s2=s2.concat("Pa");
		
		System.out.println(s +" "+s.hashCode());
		System.out.println(s2 +" "+s2.hashCode());
		
	}

}
