public class Fila {
	
	private int[] fila;
	private int head;
	private int tail;
	private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
    	fila = new int[capacidade];
    	head = -1;
    	tail = -1;
    	size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
    	return size == fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) throw new RuntimeException("A fila já está cheia");
        if (isEmpty()) head++;
        
        size++;
        
        
        fila[++tail % fila.length] = valor;
        
        System.out.println(head);
        System.out.println(tail);
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia");
        size--;
        
        int elemento = fila[head];
        head = (head + 1) % fila.length;
        
        System.out.println(head);
        System.out.println(tail);
        
        return elemento;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia");
        return fila[head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia");
        return fila[tail];
    }

    // deve retornar uma string representando a fila.
    @Override
	public String toString() {
    	String out = "";
    	for (int i = head; i <= tail; i++) {
    		if (i + 1 > tail) {
    			out += fila[i];
    		}
    		out += fila[i] + ", ";
    	}
    	
        return out;
    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro.
    public int indexOf(int valor) {
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
        return -1;
    }

    public int size() {
        return size;
    }

}
