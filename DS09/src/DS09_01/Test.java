package DS09_01;

public class Test {
	public static void main(String[] args) {		
		ArrayTest at;
		at = new ArrayTest(10);
			
		System.out.println("������ �迭 a�� ������ �����ϴ�.");
		System.out.print("�迭�� ���� : ");	at.print();	
			
		
		System.out.println("�迭 a���� 3�� ����� ��� �����մϴ�.");
		at.removemultiples(3); System.out.print("�迭�� ũ�� : "); at.print();
		System.out.println();
		
		System.out.println("�迭 a�� ������ �� �� Ȯ���մϴ�.");
		System.out.print("�迭�� ���� : ");	at.print();
		at.doublelength();
		System.out.print("�迭�� ���� : ");	at.print();
	}

}
