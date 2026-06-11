package sortedAdd;

import java.util.Scanner;

public class SortedAdd {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int value = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(sortedAdd(v, value));
	}

	private static String sortedAdd(int[] v, int value) {
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.sortedAdd(num);
		}
		
		list.sortedAdd(value);
		
		return list.toString();
	}

	private static int[] converteInt(String[] linha) {
		if (linha.length == 1 && linha[0].isBlank()) return new int[0];
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
	
	public void sortedAdd(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			addLast(newNode.value);
			return;
		}
		
		if (newNode.value < head.value) {
			addFirstNode(newNode);
			return;
		}
		
		Node noAux = head.next;
		while (noAux != null) {
			if (newNode.value <= noAux.value) {
				insereNo(newNode, noAux);
				return;
			}
			noAux = noAux.next;
		}
		
		addLast(newNode.value);
	}

	private void addFirstNode(Node newNode) {
		newNode.next = head;
		head.prev = newNode;
		tamanho++;
		head = newNode;
	}

	private void insereNo(Node newNode, Node noAux) {
		newNode.next = noAux;
		newNode.prev = noAux.prev;
		newNode.prev.next = newNode;
		noAux.prev = newNode;
		tamanho++;
	}

	public void addLast(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		
		tamanho++;
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "";
		String out = "";
		Node noAux = head;
		while (noAux != null) {
			out += noAux.value + ", ";
			noAux = noAux.next;
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
