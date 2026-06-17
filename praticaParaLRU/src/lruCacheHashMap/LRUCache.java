package lruCacheHashMap;

import java.util.*;

public class LRUCache {
	
	private LinkedList list;
	private Map<String, Node> tabela;
	private int max;
	
	public LRUCache(int capacidade) {
		this.list = new LinkedList();
		this.tabela = new HashMap<>();
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
    	if (tabela.containsKey(chave)) return;
    	if (isFull()) {
    		String removed = list.removeFirst();
    		tabela.remove(removed);
    	}
    	
    	Node newNode = list.addLast(chave);
    	tabela.put(chave, newNode);
    }

    // deve ser O(1)
    // retorna o próprio valor se encontrar ou null.
    // Encontrando ou não, o elemento deve ser movido para o final da lista
    public String get(String value) {
    	if (tabela.containsKey(value)) {
    		Node no = tabela.get(value);
    		list.moveToTail(no);
    		return value;
    	}
    	
		addLast(value);
		return null;
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
