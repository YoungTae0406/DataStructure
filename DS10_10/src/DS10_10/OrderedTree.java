package DS10_10;

import java.util.*;

public class OrderedTree {
	private Object root;
	private List subtrees;
	private int size;
	private int data;
	
	public OrderedTree() {}
	public OrderedTree(Object root, int data) {
		this.root = root;
		this.data = data;
		subtrees = new LinkedList();
		size = 1;
	}
	public OrderedTree(Object root, List trees, int data) {
		this(root, data);
		for(Iterator it = trees.iterator(); it.hasNext(); ) {
			Object obj = it.next();
			if(obj instanceof OrderedTree) { //형변환이 가능하다
				OrderedTree tree = (OrderedTree)obj;
				subtrees.add(tree);
				size+= tree.size();
			}
		}
	}
	public int size() {
		return size;
	}
	public void levelOrder(OrderedTree roott) {
		Queue<OrderedTree> queue = new LinkedList<>();

		if(roott!=null) {
			queue.add(roott);
			System.out.print(roott.data+"-> ");
			while(queue.peek()!=null) {
				OrderedTree temp = queue.poll();
				for(Iterator it = temp.subtrees.iterator(); it.hasNext();) {
					OrderedTree obj = (OrderedTree)it.next();
					queue.add(obj);
					System.out.print(obj.data+"-> ");
				}

			}
		
			
		}

	}
}
