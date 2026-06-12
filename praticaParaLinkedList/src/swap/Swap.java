package swap;

import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int indexNode1 = Integer.parseInt(sc.nextLine());
		int indexNode2 = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteInt(linha);
		
		System.out.println(swap(v, indexNode1, indexNode2));
	}

	private static String swap(int[] v, int indexNode1, int indexNode2) {
		LinkedList list = new LinkedList();
		for (int num : v) {
			list.addLast(num);
		}
		
		Node node1;
		Node node2;
		if(indexNode1 > indexNode2) {
			node1 = list.getNode(indexNode2);
			node2 = list.getNode(indexNode1);
		} else {
			node1 = list.getNode(indexNode1);
			node2 = list.getNode(indexNode2);
		}
		
		list.swap(node1, node2);
		
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
	
	public void swap(Node node1, Node node2) {
		if (tamanho == 0) return;
		if (node1 == node2) return;
		
		if (node1.next == node2) {
			Node nodeAnterior = node1.prev;
			Node nodeSeguinte = node2.next;
			if (node1.prev == null) {
				head = node2;
				node2.prev = null;
			} else {
				nodeAnterior.next = node2;
				node2.prev = nodeAnterior;
			}
			
			if (node2.next == null) {
				tail = node1;
				node1.next = null;
			} else {
				nodeSeguinte.prev = node1;
				node1.next = nodeSeguinte;
			}
			
			node1.prev = node2;
			node2.next = node1;
			return;
		}
		
		Node node1Anterior = node1.prev;
		Node node1Seguinte = node1.next;
		Node node2Anterior = node2.prev;
		Node node2Seguinte = node2.next;
		
		if (node1Anterior == null) {
			head = node2;
			node2.prev = null;
		} else {
			node1Anterior.next = node2;
			node2.prev = node1Anterior;
		}
		
		if (node2Seguinte == null) {
			tail = node1;
			node1.next = null;
		} else {
			node2Seguinte.prev = node1;
			node1.next = node2Seguinte;
		}
		node2Anterior.next = node1;
		node1Seguinte.prev = node2;
		node1.prev = node2Anterior;
		node2.next = node1Seguinte;
		
		/**
		 * 
		Node nodeEsq = node1.prev;
		Node nodeMeio = node1.next;
		Node nodeDir = node2.next;
		
		if (nodeEsq == null) {
			head = node2;
			node2.prev = null;
		} else {
			nodeEsq.next = node2;
			node2.prev = nodeEsq;
		}
		
		if (nodeDir == null) {
			tail = node1;
			node1.next = null;
		} else {
			node1.next = nodeDir;
			nodeDir.prev = node1;
		}
		
		node2.next = nodeMeio;
		nodeMeio.next = node1;
		node1.prev = nodeMeio;
		nodeMeio.prev = node2;
		 * 
		 */
		
	}

	public Node getNode(int indexNode) {
		if (indexNode < 0 || indexNode >= tamanho) throw new IndexOutOfBoundsException("Informe um índice válido.");
		Node nodeAux = head;
		for (int i = 0; i < indexNode; i++) {
			nodeAux = nodeAux.next;
		}
		
		return nodeAux;
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

	public boolean isEmpty() {
		return tamanho == 0;
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
