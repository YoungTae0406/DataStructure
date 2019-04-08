package DS09_03;

public class BigInt {
	private Node start;
	private Node p;
	
	public BigInt() {
		
	}
	public BigInt(int n) {
		start = new Node(n%10);
		p = start;
		n = n/10;
		while(n > 0) {
			p = p.next = new Node(n%10);
			n = n/10;
		}
	}
	public BigInt(String s) { 
		String ss = s.substring(s.length()-1, s.length());
		int temp = Integer.parseInt(ss);
		start = new Node(temp);
		p = start;
		for(int i = s.length()-2; i>=0;i--) {
			ss = s.substring(i, i+1);
			temp = Integer.parseInt(ss);
			p = p.next = new Node(temp);
		}
		
	}
	public int compareMe(BigInt y) { 
		boolean cp=true;//큰, 작 논리	
		int cp2 =0 ;
		int count = 1 ;
		
		p = start; 		y.p = y.start;
		if(p.data > y.p.data) {
			cp = true;
		}else if(p.data == y.p.data) {
			cp2+= 1;
		}else if(p.data < y.p.data){
			cp = false;
		}
		while(true) {
			p = p.next;		
			y.p = y.p.next;
			if(p == null&&y.p ==null) {
				if(count==cp2) {
					return 0;
				}
				if(cp==true) {
					return 1;
				}
				else if(cp==false) {
					return -1;
				}
			}
		
			if(p == null) {
				return -1;
			}
			if(y.p == null) {
				return 1;
			}
			if(p.data > y.p.data) {
				cp = true;
			}else if(p.data == y.p.data) {
				cp2 += 1;
			}else if(p.data < y.p.data){
				cp = false;
			}	
			count++;					
		}//while문 끝
		
	}
	
	public BigInt multiple(int k) {
		BigInt a = new BigInt();
		p = start;	
		int temp = 0; int temp2 = 0; int temp3 = 0;
		
		temp = p.data * k;
		temp2 = temp%10;	//나머지
		temp3 = temp/10; //몫
		
		a.start = new Node(temp2);
		a.p = a.start ;
		
		while(p.next!=null) {
			p = p.next;
			temp = p.data * k;
			temp2 = (temp%10 + temp3)%10;	//나머지
			temp3 = temp/10 + (temp%10 + temp3)/10; //몫
			
			a.p = a.p.next = new Node(temp2);
			if(p.next==null&&temp3>0) {
				a.p.next = new Node(temp3);
				
			}
			else if(p.next==null&&temp3==0) {
				break;
			}
		}
		return a;
		
	}
	public String toString() {
		reverse();
		String temp="";
		for(p = start ; p!=null ; p=p.next) {
			temp += p.data;
		}
		return temp;
		
	}
	
	public void reverse() {
		Node prev = null;
		Node pp = start;
		while(pp != null) {
			Node next = pp.next;
			pp.next = prev; //p를 prev에 연결
			prev = pp; // prev가 한칸 이동
			pp = next; //p도 한칸 이동하고 반복
		}
		start = prev;
	}

	private class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
	}
}
