import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa. 
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
    	size++;
    	if (isEmpty()) {
    		root = new Node(element);
    	}
    	else {
    		add(root, element);
    	}
    }
    
    
    private void add(Node current, int element) {
    	if (element > current.value) {
    		if (current.right == null) {
    			Node newNode = new Node(element);
        		newNode.parent = current;
        		current.right = newNode;
        		return;
    		}
    		add(current.right, element);
    	}
    	if (element < current.value) {
    		if (current.left == null) {
    			Node newNode = new Node(element);
        		newNode.parent = current;
        		current.left = newNode;
        		return;
    		}
    		add(current.left, element);
    	}
	}

	/**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
    	if (isEmpty()) return null;
    	Node aux = root;
    	while (aux != null) {
    		if (element == aux.value) return aux;
    		if (element > aux.value) aux = aux.right;
    		else aux = aux.left;
    	}
    	
        return null;
    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(root);
    }


    private int height(Node current) {
    	if (current == null) return -1;
		return Math.max(height(current.left), height(current.right)) + 1;
	}

	public boolean equals(BST outra) {
		if(root == null && outra.root == null) {
			return true;
		}
		return equals(root, outra.root);
    }

	/**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return -1;
    }

    

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
}
