package com.jds.dsalgo.algoandds.tree;

/*       
 * input:
 *        15
 *    10        35
 * 5      12 30    40
 * 
 * output:
 *            105
 *     132           40
 *  142   120     75    0
*/
public class ReplaceNodeWithSumGreaterNode {
	public static void main(String args[]) {
		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(35);
		node.left.left = new Node(5);
		node.left.right = new Node(12);
		node.right.left = new Node(30);
		node.right.right = new Node(40);

		System.out.println(node);
		replace(node, 0);
		System.out.println(node);
	}

	static int count = 0;

	public static int replace(com.jds.dsalgo.algoandds.tree.Node root, int val) {
		if (root != null) {
			int rval = replace(root.right, val);
			int temp = root.key;
			root.key = rval;
			int lval = replace(root.left, rval + temp);
			return lval;
		}
		return val;
	}
}
