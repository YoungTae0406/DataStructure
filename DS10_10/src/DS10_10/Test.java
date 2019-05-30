package DS10_10;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		OrderedTree tree_D, tree_E, tree_B, tree_A, tree_C;
		
		OrderedTree tree_H = new OrderedTree("H", 66);
		OrderedTree tree_G = new OrderedTree("G", 22);
		OrderedTree tree_F = new OrderedTree("F", 88);
		
		List subtreesOf_D = new LinkedList();
		subtreesOf_D.add(tree_G);
		tree_D = new OrderedTree("D", subtreesOf_D, 33);
		
		List subtreesOf_E = new LinkedList();
		subtreesOf_E.add(tree_H);
		tree_E = new OrderedTree("E", subtreesOf_E, 55);
		
		List subtreesOf_B = new LinkedList();
		subtreesOf_B.add(tree_D);
		subtreesOf_B.add(tree_E);
		tree_B = new OrderedTree("B", subtreesOf_B, 44);
		
		List subtreesOf_C = new LinkedList();
		subtreesOf_C.add(tree_F);
		tree_C = new OrderedTree("C", subtreesOf_C, 99);
		
		List subtreesOf_A = new LinkedList();
		subtreesOf_A.add(tree_B);
		subtreesOf_A.add(tree_C);
		tree_A = new OrderedTree("A", subtreesOf_A, 77);
		
		tree_A.levelOrder(tree_A);
		
	}

}
