package lruCacheHashMap;

public class LRUEvictionStrategyAsserts {

    public static void main(String[] args) {
        new LRUEvictionStrategyAsserts().testStrategy();
    }

    public void testStrategy() {
        
        LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 0;
        assert lrucache.get("a").equals("miss");

        // cache status: ["a", null, null, null]
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 1;
        assert lrucache.get("a").equals("hit");
        assert lrucache.size() == 1;

        assert lrucache.get("b").equals("miss");
        assert lrucache.getNextEviction() == null;
        assert lrucache.get("c").equals("miss");
        assert lrucache.get("d").equals("miss");

        // cache status: ["a", "b", "c", "d"]
        assert lrucache.getNextEviction().equals("a");

        assert lrucache.get("b").equals("hit");
        // cache status: ["a", "c", "d", "b"]
        assert lrucache.getNextEviction().equals("a");
        
        assert lrucache.get("a").equals("hit");
        // cache status: ["c", "d", "b", "a"]

        assert lrucache.get("e").equals("miss");
        // cache status: ["d", "b", "a", "e"]
        assert lrucache.getNextEviction().equals("d");

        assert lrucache.get("c").equals("miss");
        // cache status: ["b", "a", "e", "c"]

        assert lrucache.getNextEviction().equals("b");
        assert lrucache.get("e").equals("hit");
        // cache status: ["b", "a", "c", "e"]
        assert lrucache.getNextEviction().equals("b");

        assert lrucache.get("x").equals("miss");
        // cache status: ["a", "c", "e", "x"]

        assert lrucache.get("y").equals("miss");
        // cache status: ["c", "e", "x", "y"]

        assert lrucache.get("z").equals("miss");
        // cache status: ["e", "x", "y", "z"]

        assert lrucache.getNextEviction().equals("e");
        assert lrucache.get("w").equals("miss");
        // cache status: ["x", "y", "z", "w"]

        assert lrucache.size() == 4;
        assert lrucache.getNextEviction().equals("x");    
        
        System.out.println("Todos os testes passaram!");
    }
}
