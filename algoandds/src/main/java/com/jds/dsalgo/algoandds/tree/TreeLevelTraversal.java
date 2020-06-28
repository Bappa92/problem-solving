package com.jds.dsalgo.algoandds.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeLevelTraversal {

	public static void main(String[] args) {
		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.right = new TNode(5);
		root.right.right = new TNode(7);
		root.left.left = new TNode(4);
		
		var levelNodes=new LinkedList<TNode>();
		levelNodes.add(root);
		while(!levelNodes.isEmpty()) {
			var currentLevel=new LinkedList();
			for(var thisNode:levelNodes) {
				System.out.print(thisNode.value+",");
				if(thisNode.left!=null)
					currentLevel.add(thisNode.left);
				if(thisNode.right!=null)
					currentLevel.add(thisNode.right);
			}
			levelNodes=currentLevel;
			System.out.println();
		}

	}

}

class TNode {
	TNode(int value) {
		this.value = value;
	}

	TNode left, right;
	int value;
}