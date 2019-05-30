package DS10_11;

public class Test {
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		a.insert(1);
		a.insert(3);
		a.insert(5);
		a.insert(7);
		a.insert(9);
		System.out.print("후위 순회 : ");
		a.postorder();
		System.out.print("중위 순회 : ");
		a.inorder();
		System.out.print("전위 순회 : ");
		a.preorder();

		System.out.println("tree의 높이 : "+a.height());
		System.out.println();
		BinaryTree b = new BinaryTree();
		b.insert(77);
		b.insert(44);
		b.insert(55);
		b.insert(99);
		b.insert(33);
		b.insert(66);
		b.insert(88);
		b.insert(22);
		System.out.print("후위 순회 : ");
		b.postorder();
		System.out.print("중위 순회 : ");
		b.inorder();
		System.out.print("전위 순회 : ");
		b.preorder();
		System.out.println("tree의 높이 : "+b.height());
		
	}
	
}
