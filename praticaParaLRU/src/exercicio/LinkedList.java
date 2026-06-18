package exercicio;

import java.util.NoSuchElementException;

public class LinkedList {
	private int size;
	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void addLast(String value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}	
	}
	
	public void removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("A LinkedList está vazia.");
		if (head == tail) {
			head = null;
			tail = null;
			size = 0;
		} else {
			head = head.next;
			head.prev = null;
			size--;
		}
	}
	
	public void moveToTail(Node newTail) {
		if (isEmpty() || size == 1 || newTail == tail) return;
		if (newTail == head) {
			head = head.next;
			head.prev = null;
		} else {
			newTail.next.prev = newTail.prev;
			newTail.prev.next = newTail.next;
		}
		
		tail.next = newTail;
		newTail.prev = tail;
		newTail.next = null;
		tail = newTail;
	}
	
	public Node getNode(String value) {
		Node auxNode = head;
		while (auxNode != null) {
			if (auxNode.value.equals(value)) return auxNode;
			auxNode = auxNode.next;
		}
		
		return null;
	}
	
	public boolean contains(String value) {
		Node auxNode = head;
		while (auxNode != null) {
			if (auxNode.value.equals(value)) return true;
			auxNode = auxNode.next;
		}
		
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public String seeFirst() {
		return head.value;
	}
}

class Node {
	public String value;
	public Node next;
	public Node prev;
	
	public Node(String value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
