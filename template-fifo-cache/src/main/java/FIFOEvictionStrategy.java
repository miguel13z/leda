import java.util.*;

public class FIFOEvictionStrategy {
	
	private FIFOCache fila;
	private Set<String> conjunto;

    // deve ter uma FIFOCache como atributo
    public FIFOEvictionStrategy(int capacidade) {
    	this.fila = new FIFOCache(capacidade);
    	this.conjunto = new HashSet<>();
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
    	if (conjunto.contains(chave)) {
    		return "hit";
    	} else {
    		adicionaCache(chave);
    		return "miss";
    	}
    }

    private void adicionaCache(String chave) {
    	if (fila.isFull()) {
    		String elemento = fila.removeFirst();
    		conjunto.remove(elemento);
    	}
    	
    	fila.addLast(chave);
    	conjunto.add(chave);
	}

	/*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
    	if (!fila.isFull()) {
    		return null;
    	}
    	
        return fila.getFirst();
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return fila.size();
    }

}
