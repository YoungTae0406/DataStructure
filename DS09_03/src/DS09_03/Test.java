package DS09_03;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInt test = new BigInt(13579);
		System.out.println("현재 저장된 숫자 : "+test);
		BigInt test2 = new BigInt("75313579");
		System.out.println("현재 저장된 숫자 : "+test2);
		test.reverse();	test2.reverse();
		
		System.out.println(test.compareMe(test2));
		System.out.println(test2.compareMe(test));
		
		System.out.println("현재 저장된 숫자 : "+test);
		test.reverse();
		System.out.println("multiple(4)호출");
		System.out.println("현재 저장된 숫자 : "+test.multiple(4));
		System.out.println("현재 저장된 숫자 : "+test2.multiple(4));
	}

}
