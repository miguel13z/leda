import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FilaTests {

    @Test
    public void testFilaAddLast() {
        Fila fila = new Fila(5);
        assertTrue(fila.isEmpty());
        assertFalse(fila.isFull());
        assertEquals(0, fila.size());

        fila.addLast(10);
        assertFalse(fila.isEmpty());
        assertFalse(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(10, fila.getLast());
        assertEquals(1, fila.size());

        fila.addLast(20);
        assertFalse(fila.isEmpty());
        assertFalse(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(20, fila.getLast());
        assertEquals(2, fila.size());

        fila.addLast(30);
        fila.addLast(40);
        assertFalse(fila.isEmpty());
        assertFalse(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(40, fila.getLast());
        assertEquals(4, fila.size());


        fila.addLast(50);
        assertFalse(fila.isEmpty());
        assertTrue(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(50, fila.getLast());
        assertEquals(5, fila.size());

        try {
            fila.addLast(60);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        assertFalse(fila.isEmpty());
        assertTrue(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(50, fila.getLast());
        assertEquals(5, fila.size());
    }

    @Test
    public void testFilaRemoveFirst() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.removeFirst();
        assertTrue(fila.isEmpty());
        assertFalse(fila.isFull());
        assertEquals(0, fila.size());

        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assertFalse(fila.isEmpty());
        assertTrue(fila.isFull());
        assertEquals(10, fila.getFirst());
        assertEquals(5, fila.size());

        try {
            fila.addLast(500);
            fail("esta linha não pode ser executada");
        } catch (Exception e) {}


        fila.removeFirst();
        fila.addLast(60);
        // 20, 30, 40, 50, 60
        assertEquals(60, fila.getLast());
        assertEquals(5, fila.size());

        fila.removeFirst();
        fila.removeFirst();
        fila.removeFirst();
        
        // 50, 60
        assertFalse(fila.isFull());
        assertEquals(2, fila.size());
        fila.removeFirst();
        fila.removeFirst();
        
        try {
            fila.removeFirst();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}
        
        try {
            fila.getLast();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {};
    }

    @Test
    public void testFilaToString() {
        Fila fila = new Fila(5);
        assertEquals("", fila.toString());
        fila.addLast(10);
        assertEquals("10", fila.toString());
        fila.addLast(20);
        assertEquals("10, 20", fila.toString());
        fila.addLast(30);
        assertEquals("10, 20, 30", fila.toString());
        fila.removeFirst();
        assertEquals("20, 30", fila.toString());
        fila.addLast(30); 
        fila.addLast(40);
        fila.addLast(50);
        assertEquals("20, 30, 30, 40, 50", fila.toString());
        
    }	

    @Test
    public void testFilaIndexOf() {
        Fila fila = new Fila(5);
        assertEquals(-1, fila.indexOf(10));
        fila.addLast(10);
        assertEquals(0, fila.indexOf(10));
        fila.addLast(20);
        assertEquals(1, fila.indexOf(20));
        assertEquals(0, fila.indexOf(10));

        fila.addLast(30);
        fila.addLast(10);
        assertEquals(0, fila.indexOf(10));
    }


    @Test
    public void testFilaLastIndexOf() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assertEquals(4, fila.lastIndexOf(50));
        assertEquals(0, fila.lastIndexOf(10));

        assertEquals(2, fila.lastIndexOf(30));
        fila.removeFirst();
        fila.addLast(50);
        assertEquals(1, fila.lastIndexOf(30));

        assertEquals(3, fila.indexOf(50));
    }
}
