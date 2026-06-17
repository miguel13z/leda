import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testStrategy() {
        
        LFUEvictionStrategy lfucache = new LFUEvictionStrategy(4);
        assertNull(lfucache.getNextEviction());
        assertEquals(0, lfucache.size());

        assertEquals("miss", lfucache.get("a"));
        // cache status: [<"a", 1>, null, null, null]
        assertNull(lfucache.getNextEviction());
        assertEquals(1, lfucache.size());

        assertEquals("hit", lfucache.get("a"));
        assertEquals("hit", lfucache.get("a"));
        // cache status: [<"a", 3>, null, null, null]
        assertEquals(1, lfucache.size());

        assertEquals("miss", lfucache.get("b"));
        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, null]
        assertNull(lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("d"));
        // cache status: [<"d", 1>, <"c", 1>, <"b", 1>, <"a", 3>]
        assertEquals("d", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "d" foi para o final da fila, pois é o elemento mais acessado
        // e "c" passa a ser o menos acessado.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("e"));
        // cache status: [<"e", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "c" teve que sair para entrada do "e", pois "c" é o menos acessado da fila.
        assertEquals("e", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());

        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"b", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // trocamos o "e" e "b", pois "e" foi mais acessado que "b"
        // e "b" passa a ser o elemento menos acessado da fila.
        assertEquals("b", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // "b" teve que sair para "c" voltar, pois "b" é o menos acessado da fila.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("e"));
        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"c", 1>, <"a", 3>, <"e", 4>, <"d", 4>]
        assertEquals("c", lfucache.getNextEviction());
        
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        // cache status: [<"a", 3>, <"e", 4>, <"d", 4>, <"c", 5>]
        // "c" foi para o final da fila, pois é o elemento mais acessado
        // e "a" passa a ser o menos acessado.
        assertEquals("a", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());

        lfucache = new LFUEvictionStrategy(2);
        assertNull(lfucache.getNextEviction());
        assertEquals(0, lfucache.size());

        assertEquals("miss", lfucache.get("x"));
        // cache status: [<"x", 1>, null]
        assertNull(lfucache.getNextEviction());
        assertEquals(1, lfucache.size());

        assertEquals("miss", lfucache.get("y"));
        // cache status: [<"y", 1>, <"x", 1>]
        assertEquals("y", lfucache.getNextEviction());
        assertEquals(2, lfucache.size());

        assertEquals("hit", lfucache.get("y"));
        // cache status: [ <"x", 1>, <"y", 2>]
        assertEquals("hit", lfucache.get("y"));
        // cache status: [ <"x", 1>, <"y", 3>]
        assertEquals("x", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("z"));
        // cache status: [<"z", 1>, <"y", 3>]
        assertEquals("z", lfucache.getNextEviction());
        assertEquals(2, lfucache.size());
    }
}
