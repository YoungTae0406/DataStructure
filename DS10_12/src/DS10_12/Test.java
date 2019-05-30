package DS10_12;

public class Test {
	public static void main(String[] args) {
		int ary[] = {17, 11, 7, 53, 4, 13 ,12, 8};
		int delete[] = {53, 11, 7, 12 ,14, 13};
		AVLTree tree = new AVLTree(14);
		for(int i=0;i<ary.length;i++) {
			tree.grow(ary[i]);
		}
		System.out.println(tree);
		for(int i=0;i<delete.length;i++) {
			tree.remove(delete[i]);
			System.out.print(delete[i]+"  »èÁ¦ : ");
			System.out.println(tree);
		}
		
	}
	
}
