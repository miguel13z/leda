package predecessorBST;

import java.util.*;

public class PredecessorBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int num = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteLinha(linha);
		
		System.out.println(predecessorBST(v, num));
	}

	private static String predecessorBST(int[] v, int num) {
		BST tree = new BST();
		for (int value : v) {
			tree.add(value);
		}
		
		return tree.predecessor(num);
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
	private Node root;
	private int size;
	
	public BST() {
		this.root = null;
		this.size = 0;
	}
	
	public void add(int value) {
		size++;
		if (isEmpty()) {
			root = new Node(value);
		} else {
			add(root, value);
		}
	}
	
	public String predecessor(int value) {
		Node node = search(value);
		List<Integer> lista = new ArrayList<>();
		if (node.left != null) {
			lista.add(node.value);
			max(node.left, lista);
		} else {
			subidaPredecessor(node, value, lista);
		}
		
		return lista.toString();
	}

	
	private void subidaPredecessor(Node current, int value, List<Integer> lista) {
		if (current == null) return;
		if (value > current.value) lista.add(current.value);
		else {
			lista.add(current.value);
			subidaPredecessor(current.parent, value, lista);
		}
	}

	private void max(Node current, List<Integer> lista) {
		if (current == null) return;
		else {
			lista.add(current.value);
			max(current.right, lista);
		}
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
	
	private Node search(int value) {
		return search(root, value);
	}
	
	private Node search(Node current, int value) {
		if (current == null) return null;
		if (current.value == value) return current;
		if (value > current.value) return search(current.right, value);
		else return search(current.left, value);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "vazia";
		else {
			String out = preOrdem(root);
			return out.substring(0, out.length() - 1);
		}
	}

	private String preOrdem(Node current) {
		if (current == null) return "";
		return current.value  + " " + preOrdem(current.left) + preOrdem(current.right);
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
