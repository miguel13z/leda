public class FIFOCache {

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
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

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        // TODO
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        // TODO 
        return 0;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
        return "";
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        return "";
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return "";
    }
    
    public int size() {
        // TODO
        return 0;
    }
}
