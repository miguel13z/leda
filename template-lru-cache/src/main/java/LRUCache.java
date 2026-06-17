public class LRUCache {
	private LinkedList list;
	private int max;

    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LRUCache(int capacidade) {
    	this.list = new LinkedList();
    	this.max = capacidade;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == max;
    }

    // deve ser O(1)
    public void addLast(String chave) {
    	if (isFull()) {
    		list.removeFirst();
    		list.addLast(chave);
    		return;
    	}
    	
    	list.addLast(chave);
    }

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Encontrando ou não, o elemento deve ser movido para o final da lista
    public String get(String value) {
    	if (!list.contain(value)) return null;
    	Node no = list.getNode(value);
    	list.moveToTail(no);
        return value;
    }

    // O(1)
    public String getFirst() {
        return list.getFirst();
    }

    // O(1)
    public String getLast() {
        return list.getLast();
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return list.toString();
    }
    
    public int size() {
        return list.size();
    }
}
