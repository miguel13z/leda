package equalsBST;

import java.util.*;

public class EqualsBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha1 = sc.nextLine().split(" ");
		String[] linha2 = sc.nextLine().split(" ");
		sc.close();
		int[] v1 = converteLinha(linha1);
		int[] v2 = converteLinha(linha2);
		
		System.out.println(bstEquals(v1, v2));
	}

	private static boolean bstEquals(int[] v1, int[] v2) {
		BST tree1 = new BST();
		BST tree2 = new BST();
		
		for (int num : v1) {
			tree1.add(num);
		}
		
		for (int num : v2) {
			tree2.add(num);
		}
		
		return tree1.equals(tree2);
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
	
	public void add (int value) {
		if (isEmpty()) {
			Node newNode = new Node(value);
			root = newNode;
		} else {
			add(root, value);
		}
	}
	
	public boolean equals(BST outra) {
		return equals(root, outra.root);
	}
	
	private boolean equals(Node current1, Node current2) {
		if (current1 == null && current2 == null) return true;
		if (current1 == null || current2 == null) return false;
		if (current1.value == current2.value) return true && 
				equals(current1.left, current2.left) && equals(current1.right, current2.right);
		return false;
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

	public boolean isEmpty() {
		return root == null;
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
