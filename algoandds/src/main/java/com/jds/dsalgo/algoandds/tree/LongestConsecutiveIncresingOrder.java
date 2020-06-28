package com.jds.dsalgo.algoandds.tree;

public class LongestConsecutiveIncresingOrder {

	public static void main(String args[]) {
		LongestConsecutiveIncresingOrder longestConsecutiveIncresingOrder = new LongestConsecutiveIncresingOrder();
		BinaryTree tree = longestConsecutiveIncresingOrder.new BinaryTree();
		tree.root = tree.new Node(6);
		tree.root.right = tree.new Node(9);
		tree.root.right.left = tree.new Node(7);
		tree.root.right.right = tree.new Node(10);
		tree.root.right.right.right = tree.new Node(11);
		tree.root.right.right.right.right = tree.new Node(12);


		System.out.println(tree.longestConsecutive(tree.root));
	}

	class BinaryTree {
		class Node {
			int data;
			Node left, right;

			Node(int item) {
				data = item;
				left = right = null;
			}
		}

		Node root;

		public BinaryTree() {
		}

		public int longestConsecutive(Node node) {
			if (node == null) {
				return 0;
			}
			int lc = 0;
			if (node.left != null && node.left.data == node.data + 1) {
				lc = 1+longestConsecutive(node.left);
			} else {
				lc = longestConsecutive(node.left);

			}
			int rc = 0;
			if (node.right != null && node.right.data == node.data + 1) {
				rc = 1+longestConsecutive(node.right);
			} else {
				rc = longestConsecutive(node.right);

			}
			return Math.max(lc, rc);
		}

	}
}
