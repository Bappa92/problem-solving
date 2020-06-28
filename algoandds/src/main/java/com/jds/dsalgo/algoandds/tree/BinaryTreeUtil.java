package com.jds.dsalgo.algoandds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Node root = null;
		for (int item : a) {
			Queue<Node> queue = new LinkedList<>();
			root = insertRecursively(root, item, queue);
		}
		System.out.println("recursivly:"+root);
		
		Node root1 = null;
		for (int item : a) {
			root1 = insertIteratively(root1, item);
		}
		System.out.println("ierativly:"+root1);
	}

	public static Node insertIteratively(Node root,int item)
	{
		if(root==null) 
		{
			return new Node(item);
		}
		Queue< Node> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node node=queue.poll();
			if(node.left==null) 
			{
				node.left=new Node(item);
				break;
			}else 
			{
				queue.offer(node.left);
			}
			if(node.right==null) 
			{
				node.right=new Node(item);
				break;
			}else
			{
				queue.offer(node.right);
			}
				
		}
		return root;
	}
	public static Node insertRecursively(Node root, int item, Queue<Node> queue) {
		if (root == null) {
			root = new Node(item);
			return root;
		}
		if (root.left == null) {
			root.left = new Node(item);
			return root;
		} else {
			queue.add(root.left);
		}
		if (root.right == null) {
			root.right = new Node(item);
			return root;
		} else {
			queue.add(root.right);
		}
		insertRecursively(queue.poll(), item, queue);
		return root;
	}
}
