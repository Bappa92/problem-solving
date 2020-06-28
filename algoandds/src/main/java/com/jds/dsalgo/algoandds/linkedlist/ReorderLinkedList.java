package com.jds.dsalgo.algoandds.linkedlist;

public class ReorderLinkedList {

	public static void main(String[] args) {
		ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		reorderLinkedList.reorderlist(head);
	}
	// Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

	Node reorderlist(Node head) {
		Node currentNode = head;
		while (currentNode != null && currentNode.next != null) {

			Node lastNode = currentNode.next;
			Node previousNode = currentNode.next;
			while (lastNode.next != null) {
				previousNode = lastNode;
				lastNode = lastNode.next;
			}
			lastNode.next = currentNode.next;
			currentNode.next = lastNode;
			previousNode.next = null;
			//
			currentNode = lastNode.next;
		}
		return head;
	}

	void print(Node head) {
		while (head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}
		System.out.println();
	}
}
