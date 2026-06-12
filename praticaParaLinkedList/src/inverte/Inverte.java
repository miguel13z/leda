package inverte;

import java.util.Scanner;

public class Inverte {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(inverte(v));
	}
	
	private static String inverte(int[] v) {
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.addLast(num);
		}
		
		list.inverte();
		
		return list.toString();
	}

	private static int[] converteInt(String[] linha) {
		if (linha.length == 1 && linha[0].isBlank()) return new int[0];
		int[] v = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
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

	public void inverte() {
		if (isEmpty()) return;
		if (tamanho == 1) return;
		Node current = head;
		Node nextNode = current.next;
		while (true) {
			current.next = current.prev;
			current.prev = nextNode;
			current = current.prev;
			if (current == null) break;
			nextNode = current.next;
		}
		
		Node nodeAux = head;
		head = tail;
		tail = nodeAux;
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
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		
		tamanho++;
		
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "";
		String out = "";
		Node nodeAux = head;
		while (nodeAux != null) {
			out += nodeAux.value + ", ";
			nodeAux = nodeAux.next;
		}
		
		return out.substring(0, out.length() - 2);
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}
}

class Node {
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int value) {
		this.value = value;
	}
}
