package contaMenores;

import java.util.*;

public class ContaMenores {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int target = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteLinha(linha);
		
		contaMenores(v, target);
	}

	private static void contaMenores(int[] v, int target) {
		BST tree = new BST();
		for (int value : v) {
			tree.add(value);
		}
		
		System.out.println(tree.toString());
		System.out.println(tree.contaMenores(target));
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
	
	public void add(int value) {
		if (isEmpty()) {
			Node newNode = new Node(value);
			root = newNode;
		} else {
			add(root, value);
		}
	}
	
	public int contaMenores(int value) {
		if (isEmpty()) return 0;
		
		int count = 0;
		Node noAux = root;
		while (noAux != null) {
			if (noAux.value == value) {
				count += contaSubArvore(noAux.left);
				break;
			}
			else if (value < noAux.value) {
				noAux = noAux.left;
			} else {
				count += 1 + contaSubArvore(noAux.left);
				noAux = noAux.right;
			}
		}
		
		return count;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "vazia";
		else {
			ArrayList<Integer> lista = new ArrayList<>();
			preOrdem(root, lista);
			return lista.toString();
		}
	}
	
	private void preOrdem(Node current, ArrayList<Integer> lista) {
		if (current == null) return;
		else {
			lista.add(current.value);
			preOrdem(current.left, lista);
			preOrdem(current.right, lista);
		}
	}

	private int contaSubArvore(Node node) {
		if (node == null) return 0;
		return 1 + contaSubArvore(node.left) + contaSubArvore(node.right);
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
	
	public Node (int value) {
		this.value = value;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
}
