package DS10_06;

public class DLinkedQueue {
	private Node head = new Node(null); //빈 더미
	int size=0;
	
	
	public void add(Object o) {//앞에서 삽입
		Node temp = new Node(o);
		
		if(head.next==null) {//처음
			head.next = temp;
			temp.prev = head;
			head.prev = temp;
			temp.next = head;
			
		}
		else {
			temp.next = head.next;
			head.next.prev = temp; 
			head.next = temp;
			temp.prev = head;
		}
		size++;
		
	}
	public Object remove() {//뒤에서 제거
		Object temp = head.prev.data;
		
		head.prev.prev.next = head;
		head.prev = head.prev.prev;
		
		size--;
		return temp;
	}
	public boolean empty() {
		return size==0;
	}
	public Object first() { //삭제될 데이터를 반환
		if(size==0) throw new IllegalStateException("the queue is empty");
		return head.prev.data;
	}
	public int size() {
		return size;
	}
	private class Node{
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object o) {
			this.data = o;
		}
		public Node(Object o, Node prev, Node next) {
			this.data = o;
			this.prev = prev;
			this.next = next;
		}
	}
}
