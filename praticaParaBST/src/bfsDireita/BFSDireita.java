package bfsDireita;

import java.util.*;

public class BFSDireita {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int[] v = converteLinha(linha);
		sc.close();
		
		System.out.println(bfsDireita(v));
	}

	private static String bfsDireita(int[] v) {
		BST tree = new BST();
		for (int num : v) {
			tree.add(num);
		}
		
		return tree.caminharEmLargura();
	}

	private static int[] converteLinha(String[] linha) {
		if (linha[0].isEmpty()) return new int[0];
		int[] v = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}

}

class BST {
	private Node root;
	
	public BST() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(int value) {
		if (isEmpty()) {
			Node newNode = new Node(value);
			root = newNode;
		} else {
			add(root, value);
		}
	}
	
	public String caminharEmLargura() {
		if (isEmpty()) return "vazia";

		Queue<Node> fila = new LinkedList<>();
		String out = "";
		fila.add(root);
		while (!fila.isEmpty()) {
			Node current = fila.remove();
			if (current.right != null) {
				fila.add(current.right);
			}
			if (current.left != null) {
				fila.add(current.left);
			}
			out += current.value + " ";
		}
		
		return out.substring(0, out.length() - 1);
	}

	private void add(Node current, int value) {
		if (value > current.value) {
			if (current.right == null) {
				Node newNode = new Node(value);
				current.right = newNode;
				newNode.parent = current;
			} else {
				add(current.right, value);
			}
		} else {
			if (current.left == null) {
				Node newNode = new Node(value);
				current.left = newNode;
				newNode.parent = current;
			} else {
				add(current.left, value);
			}
		}
	}
}

class Node {
	public int value;
	public Node parent;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
}
