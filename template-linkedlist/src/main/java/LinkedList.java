public class LinkedList {
	private Node head;
	private Node tail;
	private int tamanho;
    
    public LinkedList() {
    	this.head = null;
    	this.tail = null;
    	this.tamanho = 0;
    }
   
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void addFirst(int valor) {
    	Node newNode = new Node(valor);
    	if (tamanho == 0) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		newNode.next = head;
    		head.prev = newNode;
    		head = newNode;
    	}
    	
    	tamanho++;
    }

    public void addLast(int valor) {
    	Node newNode = new Node(valor);
    	if (tamanho == 0) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		tail.next = newNode;
    		newNode.prev = tail;
    		tail = newNode;
    	}
    	
    	tamanho++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
    	if (index < 0 || index > tamanho) throw new IndexOutOfBoundsException("Index inválido.");
    	
    	if (index == 0) addFirst(valor);
    	else if (index == tamanho) addLast(valor);
    	else {
    		Node newNode = new Node(valor);
    		Node noDir = head;
    		for (int i = 0; i < index; i++) {
    			noDir = noDir.next;
    		}
    			
    		newNode.prev = noDir.prev;
    		noDir.prev.next = newNode;
    		newNode.next = noDir;
    		noDir.prev = newNode;
    		
    		tamanho++;
    	}
    }

    public int getFirst() {
        return head.value;
    }

    public int getLast() {
        return tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Index inválido.");
    	return get(head, index);
    }

    private int get(Node node, int index) {
		if (index == 0) return node.value;
		return get(node.next, index - 1);
	}

	// deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
    	if (tamanho == 0) throw new RuntimeException("A LinkedList está vazia.");
    	
    	int elemento = head.value;
    	if (tamanho == 1) {
    		head = null;
    		tail = null;
    	} else {
        	head = head.next;
        	head.prev = null;
        	
    	}
    	tamanho--;
    	
        return elemento;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
    	if (tamanho == 0) throw new RuntimeException("A LinkedList está vazia.");
    	
    	int elemento = tail.value;
    	if (tamanho == 1) {
    		head = null;
    		tail = null;
    	} else {
    		tail = tail.prev;
        	tail.next = null;
    	}
    	tamanho--;
    	
        return elemento;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Index inválido.");
    	
    	if (index == 0) return removeFirst();
    	else if (index == tamanho - 1) return removeLast();
    	else {
    		Node noAux = head;
    		for (int i = 0; i < index; i++) {
    			noAux = noAux.next;
    		}
    		
    		noAux.prev.next = noAux.next;
    		noAux.next.prev = noAux.prev;
    		tamanho--;
    		
    		return noAux.value;
    	}
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
    	Node nodeAux = head;
    	int i = 0;
    	while (nodeAux != null) {
    		if (nodeAux.value == value) {
    			remove(i);
    			return true;
    		}
    		nodeAux = nodeAux.next;
    		i++;
    	}
    	
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
    	return indexOf(head, value);
    }

    private int indexOf(Node node, int value) {
    	if (node == null) return -tamanho - 1;
    	if (node.value == value) return 0;
    	return indexOf(node.next, value) + 1;
	}

	public boolean contain(int v) {
    	return contains(head, v);
    }
   
    private boolean contains(Node node, int v) {
		if (node == null) return false;
		if (node.value == v) return true;
    	return contains(node.next, v);
	}
    
    public int sum() {
    	return sum(head);
    }

	private int sum(Node node) {
		if (node == null) return 0;
		return node.value + sum(node.next);
	}

	// Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
    	Node nodeAux = head;
    	int index = -1;
    	int j = 0;
    	while (nodeAux != null) {
    		if (nodeAux.value == valor) {
    			index = j;
    		}
    		nodeAux = nodeAux.next;
    		j++;
    	}
    	
        return index;
    }
    
    public void insereOrdenado(int v) {
    	if (tamanho == 0) {
    		addFirst(v);
    		return;
    	}
    	
    	Node noDir = head;
    	for (int i = 0; i < tamanho; i++) {
    		if (v < noDir.value) {
    			break;
    		}
    		noDir = noDir.next;
    	}
    	
    	if (noDir == null) {
    		addLast(v);
    		return;
    	}
    	
    	if (noDir == head) {
    		addFirst(v);
    		return;
    	}
    	
    	Node newNode = new Node(v);
    	noDir.prev.next = newNode;
    	newNode.prev = noDir.prev;
    	newNode.next = noDir;
    	noDir.prev = newNode;
    	tamanho++;
    }
    
    public void swap(Node n1, Node n2) {
    	Node a0 = n1.prev;
    	Node a1 = n1.next;
    	Node b0 = n2.prev;
    	Node b1 = n2.next;
    	
    	if (a0 != null) {
    		a0.next = n2;
    	} else {
    		head = n2;
    	}
    	
    	if (b0 != null) {
    		b0.next = n1;
    	} else {
    		head = n1;
    	}
    	
    	if (a1 != null) {
    		a1.prev = n2;
    	} else {
    		tail = n2;
    	}
    	
    	if (b1 != null) {
    		b1.prev = n1;
    	} else {
    		tail = n1;
    	}
    	
    	if (a1 == b0 || b1 == a0) {
    		a1.next = n1;
    		a1.prev = n2;
    	}
    	
    	n2.prev = a0;
    	n1.next = b1;
    	n1.prev = b0;
    	n2.next = a1;
    	
    	
    	
    	
    	/**
    	 * Código pra trocar sem ser nas extremidades
    	 * 
    	 * if (a0 != null && b0 != null && a1 != null & b1 != null) {
    		a0.next = n2; ok
    		n2.prev = a0;
    		n1.next = b1;
    		n1.prev = b0;
    		a1.prev = n2; ok
    		b0.next = n1; ok
    		n2.next = a1;
    		b1.prev = n1; ok
    		return;
    	}
    	 */
    }
    

	//Obs: perguntar se pode fazer referenciando os nós da esquerda e direita
    public void moveToHead(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Index inválido.");
    	if (index == 0) return;
    	
    	Node noCabeca = head;
    	for (int i = 0; i < index; i++) {
    		noCabeca = noCabeca.next;
    	}
    	
    	if (noCabeca.next == null) {
    		tail = noCabeca.prev;
    		noCabeca.prev.next = null;
    		noCabeca.next = head;
    		noCabeca.prev = null;
    		head.prev = noCabeca;
    		head = noCabeca;
    		return;
    	}
    	
    	noCabeca.prev.next = noCabeca.next;
		noCabeca.next.prev = noCabeca.prev;
		noCabeca.next = head;
		noCabeca.prev = null;
		head.prev = noCabeca;
		head = noCabeca;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";
        
        String out = toString(head);
        
        return out.substring(0, out.length() - 2);
    }
    
    private String toString(Node node) {
    	if (node == null) return "";
		return node.value + ", " + toString(node.next);
	}

	public int size() {
        return tamanho;
    }
    
    public Node getNo(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Index inválido.");
    	return getNo(head, index);
    }

	private Node getNo(Node node, int index) {
		if (index == 0) return node;
		return getNo(node.next, index - 1);
	}
}

class Node {

    public int value;
    public Node prev;
    public Node next;

    Node(int v) {
        this.value = v;
    }

}