package exercicio;

public class MeusTestes {

	public static void main(String[] args) {
		LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
        lrucache.get("a");
        lrucache.get("b");
        lrucache.get("c");
        lrucache.get("d");
        // cache status: ["a", "b", "c", "d"]
        System.out.println(lrucache.get("b")); //hit
        // cache status: ["a", "c", "d", "b"] -> "b" foi acessado e pulou para o fim (mais recente)
        System.out.println(lrucache.get("a")); // a
        // cache status: ["c", "d", "b", "a"] -> "a" pulou para o fim. "c" agora é o mais velho.
        
        System.out.println(lrucache.get("e")); // miss
        // cache status: ["d", "b", "a", "e"] -> O cache encheu. "c" teve que sair para entrada do "e".
        
        System.out.println(lrucache.getNextEviction());
	}

}
