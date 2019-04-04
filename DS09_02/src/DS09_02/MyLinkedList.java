package DS09_02;
import java.util.*;

public class MyLinkedList {
	private Node start;	//처음 시작 지점
	private Node p; //걸어나가는 지점
	
	public MyLinkedList(int s) {
		Random rd = new Random();
		int a = rd.nextInt(11);
		start = new Node(a);
		p =  start;
		
		for(int i=0;i<s-1;i++) { //노드 객체 생성
			int temp = rd.nextInt(11);
			temp = rd.nextInt(11);
			p.next = new Node(temp);
			p = p.next;
		
		}
	}
	public void removemultiples(int x) { 
		for(p = start; p.next!=null; ) {
			if(start.data%x==0&&start.data!=0) start = start.next;
			if(p.next.data%x==0&&p.next.data!=0) {
				p.next = p.next.next;
			}
			else {
				p = p.next;
			}
		}
	}
	public void reverse() {
		Node prev = null;
		Node p = start;
		while(p != null) {
			Node next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		start = prev;
	}
	public void print() {
		System.out.print("현재 리스트의 구조 : ");
		for(p = start; p != null ; p=p.next) {
			System.out.print(p.data+" -> ");
		}
	}
	
	private class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
			
		}
		public Node(int data) {
			this.data = data;
		}
		
	}
	

}