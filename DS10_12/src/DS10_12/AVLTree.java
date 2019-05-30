package DS10_12;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	private static final AVLTree NIL = new AVLTree();
	
	public AVLTree() { //���� Ʈ��
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
		return left + " " + key + " "+ right; //�����
	}
	
	public AVLTree grow(int key) {//����
		if(this == NIL) {//�����̸�
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
		if(right.height > left.height+1) {//���������� ����
			if(right.left.height > right.right.height)//������ ����ȸ��
				right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height+1) {//�������� ����
			if(left.right.height > left.left.height)//���� ����ȸ��
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
	public AVLTree remove(int key) {//ã�� �θ�κп��� ��������
		if(key==this.key) {
			if(left==null&&right==null) {//�ڽĳ�尡 ����x
				return null;
			}
			else if(left==null) {//�����ڽ� ����x
				return right;
			}
			else if(right==null) {//������ �ڽ� ����x
				return left;
			}
			else {//�޿� �Ѵ� �ڽ��� ����
				return minimum(right);
			}
			
		}
		if(key>this.key) {//����������
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
		if(key<this.key) {//��������
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
