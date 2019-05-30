package DS10_11;

public class BinaryTree {
	private int key;
	private BinaryTree left, right;
	
	public BinaryTree() {
		this.key = -1;
	}
	public BinaryTree(int key) {
		this.key = key;
	}
	
	public BinaryTree(int key, BinaryTree left, BinaryTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	public void insert(int x) {
		BinaryTree root = this;
		while(true) {
			if(key == -1) {
				key = x;
				break;
			}
			if(x<root.key) {
				if(root.left==null) {
					BinaryTree temp = new BinaryTree(x);
					root.left = temp;
					break;
				}
				if(root.left!=null) {
					root = root.left;
				}
			}
			if(x>root.key) {
				if(root.right==null) {
					BinaryTree temp = new BinaryTree(x);
					root.right = temp;
					break;
				}
				if(root.right!=null) {
					root = root.right;
				}
			}
		}
		
	}
	public void preorder() { //전위 순회
		System.out.println("Key "+key+" is visited");
		if(this.left!=null) left.preorder();
		if(this.right!=null) right.preorder();
	}
	public void inorder() { //중위 순회
		if(this.left!=null) left.inorder();
		System.out.println("Key "+key+" is visited");
		if(this.right!=null) right.inorder();
		
	}
	
	public void postorder() { //후위 순회
		if(this.left!=null) {
			left.postorder();
		}
		if(this.right!=null) {
			right.postorder();
		}
		System.out.println("Key "+key+" is visited");
	}
	
	public int height() {
		if(this.left==null&&this.right==null) return 0;
		if(this.right==null) return 1+this.left.height();
		if(this.left==null) return 1+this.right.height();
		return 1+Math.max(this.left.height(), this.right.height());
		
	}
}
