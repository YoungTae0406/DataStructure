package DS10_12;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	private static final AVLTree NIL = new AVLTree();
	
	public AVLTree() { //공백 트리
		left = right = this;
		height = -1;
	}
	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
		
	}
	public AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1+Math.max(left.height, right.height);
	}
	public String toString() {
		if(this==NIL) return "";
		return left + " " + key + " "+ right; //재귀적
	}
	
	public AVLTree grow(int key) {//삽입
		if(this == NIL) {//공백이면
			return new AVLTree(key);
		}
		if(key == this.key) {
			return this;
		}
		if(key < this.key) left = left.grow(key);
		else right = right.grow(key);
		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;
	}
	public void rebalance() {
		if(right.height > left.height+1) {//오른쪽으로 일자
			if(right.left.height > right.right.height)//오른쪽 복합회전
				right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height+1) {//왼쪽으로 일자
			if(left.right.height > left.left.height)//왼쪽 복합회전
				left.rotateLeft();
			rotateRight();
		}
	}
	public void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
	public void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}
	public AVLTree remove(int key) {//찾은 부모부분에서 끝나도록
		if(key==this.key) {
			if(left==null&&right==null) {//자식노드가 존재x
				return null;
			}
			else if(left==null) {//왼쪽자식 존재x
				return right;
			}
			else if(right==null) {//오른쪽 자식 존재x
				return left;
			}
			else {//왼오 둘다 자식이 존재
				return minimum(right);
			}
			
		}
		if(key>this.key) {//오른쪽으로
			AVLTree obj = right.remove(key);
			if(obj==null) {
				right = NIL;
			}
			if(obj==right.left) {
				right = right.left;
			}
			if(obj==right.right) {
				right = right.right;
			}
			if(obj==minimum(right.right)) {
				right = minimum(right.right);
			}
		}
		if(key<this.key) {//왼쪽으로
			AVLTree obj = left.remove(key);
			if(obj==null) {
				left = NIL;
			}
			if(obj==left.right) {
				left = left.right;
			}
			if(obj==left.left) {
				left =left.left;
			}
			if(obj==minimum(left.right)) {
				left = minimum(left.right);
			}
		}
		
	}
	public AVLTree minimum(AVLTree Node) {
		if(Node.left==null)
			return Node;
		else {
			return minimum(Node.left);
		}
		
	}

}
