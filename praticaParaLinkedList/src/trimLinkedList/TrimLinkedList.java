package trimLinkedList;

import java.util.Scanner;

public class TrimLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int k = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(trimLinkedList(v, k));
	}

	private static String trimLinkedList(int[] v, int k) {
		String out = "";
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.addLast(num);
		}
		
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
	private Node head;
	private Node tail;
	private int tamanho;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.tamanho = 0;
	}
	
	public void addLast(int valor) {
		Node newNode = new Node(valor);
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
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "vazia";
		
		String out = "";
		Node auxNode = head;
		while (auxNode != null) {
			out += auxNode.value + " ";
			auxNode = auxNode.next;
		}
				
		return out.substring(0, out.length() - 1);
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