import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PilhaTests {

    @Test
    public void testPilhaPush() {
        Pilha pilha = new Pilha(5);       
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(0, pilha.size());

        pilha.push(10);
        assertFalse(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(10, pilha.peek());
        assertEquals(1, pilha.size());

        pilha.push(20);
        assertFalse(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(20, pilha.peek());
        assertEquals(2, pilha.size());

        pilha.push(30);
        pilha.push(40);
        assertFalse(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(40, pilha.peek());
        assertEquals(4, pilha.size());


        pilha.push(50);
        assertFalse(pilha.isEmpty());
        assertTrue(pilha.isFull());
        assertEquals(50, pilha.peek());
        assertEquals(5, pilha.size());

        try {
            pilha.push(60);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        assertFalse(pilha.isEmpty());
        assertTrue(pilha.isFull());
        assertEquals(50, pilha.peek());
        assertEquals(5, pilha.size());
    }

    @Test
    public void testPilhaPop() {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        pilha.pop();
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(0, pilha.size());

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);

        assertFalse(pilha.isEmpty());
        assertTrue(pilha.isFull());
        assertEquals(50, pilha.peek());
        assertEquals(5, pilha.size());

        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());
        assertEquals(0, pilha.size());
        
        try {
            pilha.pop();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}
        
        try {
            pilha.peek();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}
    }

    @Test
    public void testPilhaToString() {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        assertEquals("10", pilha.toString());
        pilha.push(20);
        assertEquals("20, 10", pilha.toString());
        pilha.push(30);
        assertEquals("30, 20, 10", pilha.toString());
        pilha.pop();
        assertEquals("20, 10", pilha.toString());
        pilha.push(30); 
        pilha.push(40);
        pilha.push(50);
        assertEquals("50, 40, 30, 20, 10", pilha.toString());
        
        // pilha vazia é string vazia 
        pilha = new Pilha(5); 
        assertEquals("", pilha.toString());
    }	

    @Test
    public void testPilhaIndexOf() {
        Pilha pilha = new Pilha(5);
        assertEquals(-1, pilha.indexOf(10));
        pilha.push(10);
        assertEquals(0, pilha.indexOf(10));
        pilha.push(20);
        assertEquals(0, pilha.indexOf(20));
        assertEquals(1, pilha.indexOf(10));

        pilha.push(30);
        pilha.push(10);
        // a primeira ocorrência já é no topo.
        assertEquals(0, pilha.indexOf(10));
    }

}
