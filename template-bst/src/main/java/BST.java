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
    
    public Node sucessor(int element) {
    	Node alvo = search(element);
    	if (alvo == null) return null;
    	if (alvo.right != null) {
    		return min(alvo.right);
    	} else {
    		
    	}
    }
    
    private Node min(Node no) {
    	if (no.left == null) return no;
    	while (no.left != null) {
    		no = no.left;
    	}
    	return no;
    }
    
    public int remove(int element) {
    	Node no = search(element);
    	if (no == null) {
    		throw new RuntimeException("O elemento não existe.");
    	}
    	size--;
    	remove(no);
    	return no.value;
    }
    

	private void remove(Node no) {
		if(isLeaf(no)) {
			
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
        if (outra == null) return false;
        return equals(this.root, outra.root);
    }

    private boolean equals(Node current1, Node current2) {
        if (current1 == null && current2 == null) {
            return true;
        }
        
        if (current1 == null || current2 == null) {
            return false;
        }
        
        if (current1.value != current2.value) {
            return false;
        }
        
        return equals(current1.left, current2.left) && equals(current1.right, current2.right);
    }

	/**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
    	if (root == null) return 0;
    	return contaFolhas(root);
    }
    
    private int contaFolhas(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	if (isLeaf(node)) {
    		return 1;
    	} 
    	return contaFolhas(node.left) + contaFolhas(node.right);
	}

	private boolean isLeaf(Node no) {
    	if (no.left == null && no.right == null) return true;
    	return false;
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
