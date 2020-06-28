package com.jds.dsalgo.algoandds.linkedlist;

public class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return  data + "";
	}
	
}
