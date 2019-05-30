package DS09_04;

public class MyLinkedStack {
	public int size;
	public Node top;

	public Object peek() { //top의 데이터를 참조
		return top.data;
	}
	public Object pop() {//top을 제거
		if(size!=0) {
			Object temp = top.data;
			top = top.next;
			size--;
			return temp;
		}
		else {
			throw new IndexOutOfBoundsException();
		}	
		
	}
	public void push(Object input) {//top 앞에서 삽입
		Node temp = new Node(input);
		temp.next = top;
		top = temp;
		//top = new Node(input, top);
		++size;
	}
	public int size() {
		return size;
	}
	public boolean isTrue(String a) {
		int rightBracket=0;
		int leftBracket=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='(') {
				rightBracket++;
			}else if(a.charAt(i)==')') {
				leftBracket++;
			}
		}
		if(rightBracket==leftBracket)
			return false;
		else {
			return true;
		}
		
	}

	private class Node {
		private Object data;
		private Node next;
		
		public Node(Object data) {
			this.data = data;
			
		}
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
			
		}
		
	}
}
