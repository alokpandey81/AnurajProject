package normalprogram;

public class ArmStrongNo {

	static boolean funArmStrongNo(int num){
		int armNo=0;
		for(int i=num;i>0;i=i/10)
		{
			armNo=armNo+(i%10)*(i%10)*(i%10);
		}
		System.out.println(armNo);
		if(armNo==num)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.println(funArmStrongNo(153));
		System.out.println(funArmStrongNo(253));
	}

}
