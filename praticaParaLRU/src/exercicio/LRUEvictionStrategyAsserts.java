package exercicio;

public class LRUEvictionStrategyAsserts{
	public static void main(String[] args) {
		testStrategy();
	}
	
	public static void testStrategy() {
	        LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
	        assert lrucache.getNextEviction() == null;
	        assert lrucache.size() == 0;
	        
	        assert "miss".equals(lrucache.get("a"));
	        // cache status: ["a", null, null, null]
	        assert lrucache.getNextEviction() == null;
	        assert lrucache.size() == 1;
	        
	        assert "hit".equals(lrucache.get("a"));
	        // cache status: ["a", null, null, null] -> "a" acessado de novo, continua sendo o mais recente.
	        assert lrucache.size() == 1;
	
	        assert "miss".equals(lrucache.get("b"));
	        assert lrucache.getNextEviction() == null;
	        assert "miss".equals(lrucache.get("c"));
	        assert "miss".equals(lrucache.get("d"));
	
	        // cache status: ["a", "b", "c", "d"]
	        assert lrucache.getNextEviction().equals("a");
	
	        assert "hit".equals(lrucache.get("b"));
	        // cache status: ["a", "c", "d", "b"] -> "b" foi acessado e pulou para o fim (mais recente)
	        assert lrucache.getNextEviction().equals("a");
	        
	        assert "hit".equals(lrucache.get("a"));
	        // cache status: ["c", "d", "b", "a"] -> "a" pulou para o fim. "c" agora é o mais velho.
	
	        assert "miss".equals(lrucache.get("e"));
	        // cache status: ["d", "b", "a", "e"] -> O cache encheu. "c" teve que sair para entrada do "e".
	        assert lrucache.getNextEviction().equals("d");
	
	        assert "miss".equals(lrucache.get("c"));
	        // cache status: ["b", "a", "e", "c"] -> "d" teve que sair para a entrada do "c".
	
	        assert lrucache.getNextEviction().equals("b");
	        
	        assert "hit".equals(lrucache.get("e"));
	        // cache status: ["b", "a", "c", "e"]
	        assert lrucache.getNextEviction().equals("b");
	
	        assert "miss".equals(lrucache.get("x"));
	        // cache status: ["a", "c", "e", "x"] -> "b" saiu.
	
	        assert "miss".equals(lrucache.get("y"));
	        // cache status: ["c", "e", "x", "y"] -> "a" saiu.
	
	        assert "miss".equals(lrucache.get("z"));
	        // cache status: ["e", "x", "y", "z"] -> "c" saiu.
	
	        assert lrucache.getNextEviction().equals("e");
	        assert "miss".equals(lrucache.get("w"));
	        // cache status: ["x", "y", "z", "w"] -> "e" saiu.
	
	        assert lrucache.size() == 4;
	        assert lrucache.getNextEviction().equals("x");    
	        
	        System.out.println("Todos os testes passaram!");
	    }
}