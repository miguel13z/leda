public class FIFOCacheAsserts {

    public static void main(String[] args) {

        FIFOEvictionStrategy fifocache = new FIFOEvictionStrategy(3);

        assert fifocache.getNextEviction() == null;
        assert fifocache.size() == 0;
        assert "miss".equals(fifocache.get("a")); 
        assert fifocache.getNextEviction() == null;
        assert fifocache.size() == 1;
        assert "hit".equals(fifocache.get("a"));
        assert fifocache.size() == 1;

        assert "miss".equals(fifocache.get("b"));
        assert fifocache.getNextEviction() == null;
        assert "miss".equals(fifocache.get("c"));
        assert "hit".equals(fifocache.get("b"));
        assert "hit".equals(fifocache.get("c"));
        assert fifocache.size() == 3;

        // agora o nextEviction não é mais nulo porque o cache está cheio
        assert fifocache.getNextEviction().equals("a");
        assert "miss".equals(fifocache.get("d"));

        // o próximo é b porque a saiu
        assert fifocache.getNextEviction().equals("b");

        // "a" teve que sair para a entrada do "d"
        assert "miss".equals(fifocache.get("a"));

        // com a entrada de a, b saiu e c é o próximo a sair
        assert fifocache.getNextEviction().equals("c");
        assert "miss".equals(fifocache.get("b"));

    }
}