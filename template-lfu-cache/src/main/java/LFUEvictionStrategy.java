public class LFUEvictionStrategy {
    
    private LFUCache cache;

    public LFUEvictionStrategy(int capacidade) {
        this.cache = new LFUCache(capacidade);
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        if (cache.get(chave) != null)
            return "hit";

        return "miss";
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    * esse método não altera o estado da fila.
    **/
    public String getNextEviction() {
        if (cache.isFull()) {
            return cache.getFirst();
        }

        return null;
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return cache.size();
    }

}
