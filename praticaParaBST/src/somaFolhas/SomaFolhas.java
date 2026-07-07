package somaFolhas;

import java.util.Scanner;

public class SomaFolhas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int[] v = converteLinha(linha);
		sc.close();
		
		System.out.println(somaFolhas(v));
	}

	private static int somaFolhas(int[] v) {
		BST tree = new BST();
		for (int num : v) {
			tree.add(num);
		}
		
		return tree.somaFolhas();
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
	Node root;
	
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
	
	public int somaFolhas() {
		if (isEmpty()) return 0;
		else return somaFolhas(root);
	}
	
	private int somaFolhas(Node current) {
		if (current == null) return 0;
		if (!isLeaf(current)) return somaFolhas(current.left) + somaFolhas(current.right);
		return current.value;
	}

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "vazia";
		else {
			String out = emOrdem(root);
			return out.substring(0, out.length() - 1);
		}
	}

	private String emOrdem(Node current) {
		if (current == null) return "";
		return emOrdem(current.left) + current.value + " " + emOrdem(current.right);
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
