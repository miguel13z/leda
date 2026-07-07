package removeBST;

import java.util.*;

public class RemoveBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha1 = sc.nextLine().split(" ");
		String[] linha2 = sc.nextLine().split(" ");
		sc.close();
		int[] nums = converteLinha(linha1);
		int[] remove = converteLinha(linha2);
		
		removeBST(nums, remove);
	}

	private static void removeBST(int[] nums, int[] remove) {
		BST tree = new BST();
		for (int num : nums) {
			tree.add(num);
		}
		for (int num : remove) {
			tree.remove(num);
			System.out.println(tree.toString());
		}
	}

	private static int[] converteLinha(String[] linha) {
		if (linha[0].isEmpty()) return new int[0];
		
		int v[] = new int[linha.length];
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
	
	public void remove(int value) {
		if (isEmpty()) return;
		Node removed = search(value);
		if (removed == null) return;
		remove(removed);
	}
	
	private void remove(Node removed) {
		int grau = grau(removed);
		if (grau == 0) {
			if (removed == root) {
				root = null;
			} else {
				Node pai = removed.parent;
				if (pai.left == removed) {
					pai.left = null;
				} else {
					pai.right = null;
				}
			}
		} else if (grau == 1) {
			Node filho;
			if (removed.left != null) {
				filho = removed.left;
			} else {
				filho = removed.right;
			}
			filho.parent = removed.parent;
			
			Node pai = removed.parent;
			if (pai == null) {
				root = filho;
			} else if (pai.left == removed) {
				pai.left = filho;
			} else {
				pai.right = filho;
			}
		} else {
			Node sucessor = sucessor(removed);
			swap(sucessor, removed);
			remove(sucessor);
		}
	}
	
	private void swap(Node node1, Node node2) {
		int aux = node1.value;
		node1.value = node2.value;
		node2.value = aux;
	}

	private int grau(Node node) {
		if (node.right == null && node.left == null) return 0;
		if (node.right != null && node.left != null) return 2;
		return 1;
	}
	
	private Node sucessor(Node node) {
		if (node.right != null) {
			return min(node.right);
		} else {
			return subida(node, node.value);
		}
	}
	
	private Node subida(Node current, int value) {
		if (current.parent == null) return null;
		if (current.parent.value > value) return current.parent;
		else return subida(current.parent, value);
	}

	private Node min(Node node) {
		if (node.left == null) return node;
		else return min(node.left);
	}
	
	private Node search(int value) {
		if (isEmpty()) return null;
		else return search(root, value);
	}
	
	private Node search(Node current, int value) {
		if (current == null) return null;
		if (current.value == value) return current;
		if (value > current.value) return search(current.right, value);
		return search(current.left, value);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "null";
		else {
			List<Integer> lista = new ArrayList<>();
			preOrdem(root, lista);
			return lista.toString();
		}
	}
	
	private void preOrdem(Node current, List<Integer> lista) {
		if (current == null) return;
		lista.add(current.value);
		preOrdem(current.left, lista);
		preOrdem(current.right, lista);
	}

	public void add(int value) {
		if (isEmpty()) {
			root = new Node(value);
		}
		else add(root, value);
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
