package DS09_02;

public class Test {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList(10);
		list.print();
		System.out.println();
		System.out.print("3�� ����� ����");
		list.removemultiples(3);
		System.out.println();
		list.print();
		System.out.println();
		System.out.println("reverse() ȣ��");
		list.reverse();
		list.print();
	}
}

