package linkedlist;

import node.Node;

public class LinkedList {
	
	private Node head;
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addLast(int element) {
		Node newNode = new Node(element);
		
		if (isEmpty()) {
			this.head = newNode;
		}
		else {
			addLast(element, head.next);
		}
	}
	
	private void addLast(int element, Node node) {
		Node newNode = new Node(element);
		
		if (node.next == null) {
			node.next = newNode;
			newNode.previous = node;
			return;
		}
		else {
			addLast(element, node.next);
		}
	}
	
	public int size() {
		if (head == null) {
			return 0;
		}
		return size(1, head.next);
	}
	
	private int size(int contador, Node node) {
		if (node.next == null) {
			return contador;
		}
		return size(contador + 1, node.next);
	}
	
	public int soma() {
		if (head == null) {
			return 0;
		}
		return head.value + soma(head.next);
	}
	
	private int soma(Node node) {
		if (node == null) {
			return 0;
		}
		return node.value + soma(node.next);
	}
	
	public boolean isSorted() {
		if (isEmpty()) {
			return true;
		}
		return isSorted(head.next, true);
	}
	
	private boolean isSorted(Node node, boolean sorted) {
		if (node.next == null) {
			return sorted;
		}
		if (node.value > node.next.value) {
			return false;
		}
		return isSorted(node.next, true);
	}
	
	public void add(int index, int element) {
		Node newNode = new Node(element);
		
		Node aux = head;
		int contador = 0;
		
		while (contador < index) {
			aux = aux.next;
			contador++;
		}
		
		aux.next = newNode;
		newNode.previous = aux;
	}
	
	public void remove(int index) {
		Node aux = head;
		
		int contador = 0;
		
		while (contador < index) {
			aux = aux.next;
			contador++;
		}
		
		aux.next = null;
	}
}
