package DS09_03;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInt test = new BigInt(13579);
		System.out.println("���� ����� ���� : "+test);
		BigInt test2 = new BigInt("75313579");
		System.out.println("���� ����� ���� : "+test2);
		test.reverse();	test2.reverse();
		
		System.out.println(test.compareMe(test2));
		System.out.println(test2.compareMe(test));
		
		System.out.println("���� ����� ���� : "+test);
		test.reverse();
		System.out.println("multiple(4)ȣ��");
		System.out.println("���� ����� ���� : "+test.multiple(4));
		System.out.println("���� ����� ���� : "+test2.multiple(4));
	}

}
