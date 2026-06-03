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
      
        size += 1;
        
        tail = (tail + 1) % fila.length;
        fila[tail] = valor;
        }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia");
        size--;
        
        int elemento = fila[head];
        if (head == tail) {
        	head = -1;
        	tail = -1;
        } else {
        	head = (head + 1) % fila.length;
        }
        
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
    	if (isEmpty()) return out;
    	
    	for (int i = 0; i < size; i++) {
            int indexFisico = (head + i) % fila.length;
            out += fila[indexFisico];
            
            if (i < size - 1) {
                out += ", ";
            }
        }
        return out;
    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro.
    public int indexOf(int valor) {
    	for (int i = 0; i < size; i++) {
            int indexFisico = (head + i) % fila.length;
            if (fila[indexFisico] == valor) {
            	return i;
            }
        }
    	
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
    	int posIndex = -1;
    	for (int i = 0; i < size; i++) {
            int indexFisico = (head + i) % fila.length;
            if (fila[indexFisico] == valor) {
            	posIndex = i;
            }
        }
    	
        return posIndex;
    }

    public int size() {
        return size;
    }

}
