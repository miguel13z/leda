package moveToHead;

import java.util.Scanner;

public class MoveToHead {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int index = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(moveToHead(v, index));
	}

	private static String moveToHead(int[] v, int index) {
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.addLast(num);
		}
		
		list.moveToHead(index);
		
		return list.toString();
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}

class LinkedList {
	private int tamanho;
	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.tamanho = 0;
		this.head = null;
		this.tail = null;
	}

	public void addLast(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		
		tamanho++;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	
		tamanho++;
	}
	
	public void moveToHead(int index) {
		if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Index inválido.");
		if (index == 0) return;
		
		Node newHead = head;
		for (int i = 0; i < index; i++) {
			newHead = newHead.next;
		}
		
		if (newHead == tail) {
			tail = tail.prev;
			tail.next = null;
		} else {
			newHead.prev.next = newHead.next;
			newHead.next.prev = newHead.prev;
		}
		
		newHead.next = head;
		newHead.prev = null;
		head.prev = newHead;
		head = newHead;
		
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "";
		String out = "";
		Node auxNode = head;
		while (auxNode != null) {
			out += auxNode.value + ", ";
			auxNode = auxNode.next;
		}
		
		return out.substring(0, out.length() - 2);
	}
}

class Node {
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
