package lruCacheHashMap;

import java.util.NoSuchElementException;


public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Node addLast(String valor) {
		Node newNode = new Node(valor);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		
		size++;
		return newNode;
	}
	
	public String removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("A LinkedList está vazia.");
		String removed = head.valor;
		if (head == tail) {
			head = null;
			tail = null;
			size = 0;
			return removed;
		}
		
		head = head.next;
		head.prev = null;
		size--;
		return removed;
	}
	
	public void moveToTail(Node node) {
		if (isEmpty() || size == 1 || node == tail) return;
		if (node == head) {
			head = head.next;
			head.prev = null;
		} else {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		
		tail.next = node;
		node.prev = tail;
		node.next = null;
		tail = node;
	}
	
	public int size() {
		return size;
	}

	public String getFirst() {
		if (isEmpty()) return null;
		return head.valor;
	}

	public String getLast() {
		if (isEmpty()) return null;
		return tail.valor;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "";
		String out = "";
		Node nodeAux = head;
		while (nodeAux != null) {
			out += nodeAux.valor + ", ";
			nodeAux = nodeAux.next;
		}
		
		return out.substring(0, out.length() - 2);
	}
}

class Node {
	public String valor;
	public Node next;
	public Node prev;
	
	public Node(String valor) {
		this.valor = valor;
		this.next = null;
		this.prev = null;
	}
}
