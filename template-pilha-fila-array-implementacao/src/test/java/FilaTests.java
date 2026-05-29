public class FilaTests {

    public void testFilaAddLast() {
        Fila fila = new Fila(5);
        assert fila.isEmpty();
        assert !fila.isFull();
        assert fila.size() == 0;

        fila.addLast(10);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 10;
        assert fila.size() == 1;

        fila.addLast(20);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 20;
        assert fila.size() == 2;

        fila.addLast(30);
        fila.addLast(40);
        assert !fila.isEmpty();
        assert !fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 40;
        assert fila.size() == 4;

        fila.addLast(50);
        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 50;
        assert fila.size() == 5;

        boolean lancou = false;
        try {
            fila.addLast(60);
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.getLast() == 50;
        assert fila.size() == 5;
    }

    public void testFilaRemoveFirst() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.removeFirst();
        assert fila.isEmpty();
        assert !fila.isFull();
        assert fila.size() == 0;

        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assert !fila.isEmpty();
        assert fila.isFull();
        assert fila.getFirst() == 10;
        assert fila.size() == 5;

        boolean lancou = false;
        try {
            fila.addLast(500);
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        fila.removeFirst();
        fila.addLast(60);
        assert fila.getLast() == 60;
        assert fila.size() == 5;

        fila.removeFirst();
        fila.removeFirst();
        fila.removeFirst();

        assert !fila.isFull();
        assert fila.size() == 2;
        fila.removeFirst();
        fila.removeFirst();

        lancou = false;
        try {
            fila.removeFirst();
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        lancou = false;
        try {
            fila.getLast();
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;
    }

    public void testFilaToString() {
        Fila fila = new Fila(5);
        assert fila.toString().equals("");
        fila.addLast(10);
        assert fila.toString().equals("10");
        fila.addLast(20);
        assert fila.toString().equals("10, 20");
        fila.addLast(30);
        assert fila.toString().equals("10, 20, 30");
        fila.removeFirst();
        assert fila.toString().equals("20, 30");
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);
        assert fila.toString().equals("20, 30, 30, 40, 50");
    }

    public void testFilaIndexOf() {
        Fila fila = new Fila(5);
        assert fila.indexOf(10) == -1;
        fila.addLast(10);
        assert fila.indexOf(10) == 0;
        fila.addLast(20);
        assert fila.indexOf(20) == 1;
        assert fila.indexOf(10) == 0;

        fila.addLast(30);
        fila.addLast(10);
        assert fila.indexOf(10) == 0;
    }

    public void testFilaLastIndexOf() {
        Fila fila = new Fila(5);
        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        assert fila.lastIndexOf(50) == 4;
        assert fila.lastIndexOf(10) == 0;

        assert fila.lastIndexOf(30) == 2;
        fila.removeFirst();
        fila.addLast(50);
        assert fila.lastIndexOf(30) == 1;

        assert fila.indexOf(50) == 3;
    }

    public static void main(String[] args) {
        FilaTests testes = new FilaTests();
        testes.testFilaAddLast();
        testes.testFilaRemoveFirst();
        testes.testFilaToString();
        testes.testFilaIndexOf();
        testes.testFilaLastIndexOf();
        System.out.println("Todos os testes de AssertsFila passaram.");
    }
}