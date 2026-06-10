package filtraLinkedList;

import java.util.Scanner;

public class FiltraLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int alvo = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(filtraLinkedList(v, alvo));
	}

	private static String filtraLinkedList(int[] v, int alvo) {
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.addLast(num);
		}
		
		list.filtra(alvo);
		
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
	
	public void filtra(int value) {
		Node nodeAux = head;
		while (nodeAux != null) {
			if (nodeAux.value == value) {
				remove(nodeAux);
			}
			nodeAux = nodeAux.next;
		}
	}

	private void remove(Node nodeAux) {
		if (nodeAux == head) {
			head = nodeAux.next;
			if (head == null) {
				head = null;
				tail = null;
				tamanho = 0;
			} else {
				head.prev = null;
				tamanho--;
			}
		} else if (nodeAux == tail) {
			tail = nodeAux.prev;
			tail.next = null;
			tamanho--;
		} else {
			nodeAux.prev.next = nodeAux.next;
			nodeAux.next.prev = nodeAux.prev;
			tamanho--;
		}
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
		this.next = null;
		this.prev = null;
	}
}
