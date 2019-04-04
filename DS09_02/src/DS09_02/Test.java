package DS09_02;

public class Test {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList(10);
		list.print();
		System.out.println();
		System.out.print("3의 배수를 제거");
		list.removemultiples(3);
		System.out.println();
		list.print();
		System.out.println();
		System.out.println("reverse() 호출");
		list.reverse();
		list.print();
	}
}

