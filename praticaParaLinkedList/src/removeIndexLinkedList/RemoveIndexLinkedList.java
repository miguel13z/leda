package removeIndexLinkedList;

import java.util.Scanner;

public class RemoveIndexLinkedList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int[] nums = converteInt(linha);
		int index = Integer.parseInt(sc.nextLine());
		sc.close();
		
		removeIndex(nums, index);
	}
	
	private static void removeIndex(int[] nums, int index) {
		LinkedList linkedList = new LinkedList();
		for (int num : nums) {
			linkedList.addLast(num);
		}
		linkedList.removeIndex(index);
		
		System.out.println(linkedList.toString());
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
	
	public void removeIndex(int index) {
		Node nodeRemovido = head;
		for (int i = 0; i < index; i++) {
			nodeRemovido = nodeRemovido.next;
		}
		Node proximo = nodeRemovido.next;
		Node anterior = nodeRemovido.prev;
		
		if (anterior == null) {
			head = proximo;
		} else {
			anterior.next = proximo;
		}
		
		if (proximo == null) {
			tail = anterior;
		} else {
			proximo.prev = anterior;
		}
		
		tamanho--;
	}

	public void addLast(int valor) {
		Node newNode = new Node(valor);
		if (tamanho == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		
		tamanho++;
	}
	
	@Override
	public String toString() {
		String out = "";
		Node nodeAux = head;
		while (nodeAux != null) {
			out += nodeAux.valor + " ";
			nodeAux = nodeAux.next;
		}
		
		return out.trim();
	}
}

class Node {
	public int valor;
	public Node next;
	public Node prev;
	
	public Node(int valor) {
		this.valor = valor;
		this.next = null;
		this.prev = null;
	}
}
