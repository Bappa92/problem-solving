package com.jds.dsalgo.algoandds.tree;

public class KLargestElements {
	static int k = 3;

	public static void main(String[] args) {
		Node root = new Node(8);

		root.left = new Node(3);
		root.right = new Node(10);

		root.left.left = new Node(1);
		root.left.right = new Node(6);

		root.right.right = new Node(14);

		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right.right.left = new Node(13);
		largestElementRecursive(root);
		largestElementIterative(root,k);
	}

	private static void largestElementIterative(Node root, int k2) {
		
	}

	private static void largestElementRecursive(Node root) {
		if(root==null) 
		{
			return;
		}
		largestElementRecursive(root.right);
		//System.out.print(root.key+",");
		k--;
		if(k==0) 
		{
			System.out.println(root.key);
			return;
		}
		largestElementRecursive(root.left);
	}

}
