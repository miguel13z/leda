package contaNosInternos;

import java.util.*;

public class ContaNosInternos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String linha[] = sc.nextLine().split(" ");
		int[] v = converteLinha(linha);
		sc.close();
		
		System.out.println(contaNosInternos(v));
	}

	private static int contaNosInternos(int[] v) {
		BST tree = new BST();
		for (int value : v) {
			tree.add(value);
		}
		
		return tree.contaNosInternos();
	}

	private static int[] converteLinha(String[] linha) {
		int[] v = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}

}

class BST {
	private int size;
	private Node root;
	
	public BST() {
		this.size = 0;
		this.root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(int value) {
		size++;
		if (isEmpty()) {
			Node newNode = new Node(value);
			root = newNode;
		} else {
			add(root, value);
		}
	}
	
	public int contaNosInternos() {
		if (isEmpty()) return 0;
		else {
			return contaNosInternos(root);
		}
	}
	
	private int contaNosInternos(Node current) {
		if (current == null) return 0;
		int value = 1;
		if (isLeaf(current)) value = 0;
		return value + contaNosInternos(current.left) + contaNosInternos(current.right);
	}

	public boolean isLeaf(Node node) {
		if (node == null) return false;
		return node.left == null && node.right == null;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "vazia";
		String out = preOrdem(root);
		return out.substring(0, out.length() - 1);
	}

	private String preOrdem(Node current) {
		if (current == null) return "";
		return current.value + " " + preOrdem(current.left) + preOrdem(current.right);
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
