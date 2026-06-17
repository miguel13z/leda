public class LFUCache {

    private int capacidade;
    private LinkedList cache;

    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LFUCache(int capacidade) {
        this.capacidade = capacidade;
        this.cache = new LinkedList();
    }

    public boolean isEmpty() {
    	return cache.size() == 0;
    }

    public boolean isFull() {
        return cache.size() == this.capacidade;
    }

    // deve ser O(1)
    public void addFirst(String chave) {
        cache.addFirst(chave);
    }

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Caso não encontre, adicione o elemento no início da fila.
    public String get(String value) {
        Node node = cache.getNode(value);
        
        if (node != null) {
            node.frequency++;
            cache.sortByFrequency(node);
            return node.value;

        } else if (this.isFull()) {
            cache.removeFirst();

        }

        this.addFirst(value);
        return null;
    }

    // O(1)
    public String getFirst() {
        if (cache.size() > 0) {
            return cache.getFirst();
        }

        return null;
    }

    // O(1)
    public String getLast() {
        if (cache.size() > 0) {
            return cache.getLast();
        }

        return null;
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return cache.toString();
    }
    
    public int size() {
        return cache.size();
    }
}
