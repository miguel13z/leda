package praticaParaLinkedList;

import java.util.Scanner;

public class TrocaVizinhosLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int[] nums = converteInt(linha);
		int indexTroca = Integer.parseInt(sc.nextLine());
		sc.close();

		trocaVizinhos(nums, indexTroca);
	}

	private static void trocaVizinhos(int[] nums, int indexTroca) {
		LinkedList linkedList = new LinkedList();
		for (int num : nums) {
			linkedList.addLast(num);
		}
		linkedList.trocaVizinhos(indexTroca);
		
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

	public void trocaVizinhos(int indexTroca) {
		Node noEsq = head;
		for (int i = 0; i < indexTroca; i++) {
			noEsq = noEsq.next;
		}
		Node noDir = noEsq.next;
		Node proximo = noDir.next;
		Node anterior = noEsq.prev;
	
		if (anterior != null) {
			anterior.next = noDir;
		}
		else {
			head = noDir;
		}
		
		if (proximo != null) {
			proximo.prev = noEsq;
		} else {
			tail = noEsq;
		}
		
		noDir.next = noEsq;
		noDir.prev = anterior;
		noEsq.next = proximo;
		noEsq.prev = noDir;
	}

	public void addLast(int valor) {
		Node newNode = new Node(valor);
		if (tamanho == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
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
	}
}