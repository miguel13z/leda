public class FIFOEvictionStrategy {

    // deve ter uma FIFOCache como atributo
    public FIFOEvictionStrategy(int capacidade) {}

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        return null;
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
        return null;
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return 0;
    }

}
