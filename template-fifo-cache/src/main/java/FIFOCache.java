public class FIFOCache {
	
	private int head;
	private int tail;
	private String[] fila;
	private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
    	this.head = -1;
    	this.tail = -1;
    	this.fila = new String[capacidade];
    	this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == fila.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
    	if (isEmpty()) {
    		head = 0;
    		tail = 0;
    		fila[0] = chave;
    		size++;
    		return;
    	}
    	
    	if (!isFull()) {
    		tail = (tail + 1) % fila.length;
    		fila[tail] = chave;
    		size++;
    		return;
    	}
    	
    	if (isFull()) {
    		removeFirst();
    		addLast(chave);
    	}
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia.");
        if (head == tail) {
        	String elemento = fila[head];
        	head = -1;
        	tail = -1;
        	size = 0;
        	return elemento;
        }
        
        String elemento = fila[head];
        head = (head + 1) % fila.length;
        size--;
        return elemento;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia.");
        return fila[head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia.");
        return fila[tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
    	if (isEmpty()) return "";
    	String out = "";
    	for (int i = 0; i < size; i++) {
    		int indexFila = (head + i) % fila.length;
    		out += fila[indexFila] + ", ";
    	}
    	
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return size;
    }
}
