public class Fila {

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        // TODO
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public boolean isFull() {
        // TODO
        return false;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        // TODO
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        // TODO 
        return 0;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        return 0;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        return 0;
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return "";
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
        // TODO
        return 0;
    }

}
