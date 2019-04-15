package DS09_05;

public class SLinkedQueue {
	private Node front = null; //앞
	private Node rear = null; //뒤
	private int size=0;
	
	public void add(Object o) {//맨 처음 시작을 고려
		Node temp = new Node(o);
		if(empty()) {
			rear = temp;
			front = temp;
		}
		else {
			rear = rear.next = temp;
		}
		size++;
	}
	public Object remove() {
		Object temp = front.data;
		front = front.next;
		if(front==null) {
			rear = null;
		}
		size--;
		return temp;

	}
	public boolean empty() {
		return size==0;
	}
	public Object first() {
		if(size==0) throw new IllegalStateException("the queue is empty");
		return front.data;
	}
	public int size() {
		return size;
	}
	
	private class Node{
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
