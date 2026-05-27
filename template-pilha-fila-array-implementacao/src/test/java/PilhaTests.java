public class AssertsPilha {

    public void testPilhaPush() {
        Pilha pilha = new Pilha(5);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;

        pilha.push(10);
        assert !pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.top() == 10;
        assert pilha.size() == 1;

        pilha.push(20);
        assert !pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.top() == 20;
        assert pilha.size() == 2;

        pilha.push(30);
        pilha.push(40);
        assert !pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.top() == 40;
        assert pilha.size() == 4;

        pilha.push(50);
        assert !pilha.isEmpty();
        assert pilha.isFull();
        assert pilha.top() == 50;
        assert pilha.size() == 5;

        boolean lancou = false;
        try {
            pilha.push(60);
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        assert !pilha.isEmpty();
        assert pilha.isFull();
        assert pilha.top() == 50;
        assert pilha.size() == 5;
    }

    public void testPilhaPop() {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        assert pilha.pop() == 10;
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);

        assert !pilha.isEmpty();
        assert pilha.isFull();
        assert pilha.top() == 50;
        assert pilha.size() == 5;

        boolean lancou = false;
        try {
            pilha.push(60);
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        assert pilha.pop() == 50;
        assert pilha.top() == 40;
        assert pilha.size() == 4;

        assert pilha.pop() == 40;
        assert pilha.pop() == 30;
        assert pilha.pop() == 20;

        assert !pilha.isFull();
        assert pilha.size() == 1;
        assert pilha.pop() == 10;
        assert pilha.isEmpty();

        lancou = false;
        try {
            pilha.pop();
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;

        lancou = false;
        try {
            pilha.top();
        } catch (Exception e) {
            lancou = true;
        }
        assert lancou;
    }

    public void testPilhaToString() {
        Pilha pilha = new Pilha(5);
        assert pilha.toString().equals("");
        pilha.push(10);
        assert pilha.toString().equals("10");
        pilha.push(20);
        assert pilha.toString().equals("10, 20");
        pilha.push(30);
        assert pilha.toString().equals("10, 20, 30");
        pilha.pop();
        assert pilha.toString().equals("10, 20");
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        assert pilha.toString().equals("10, 20, 30, 40, 50");
    }

    public void testPilhaIndexOf() {
        Pilha pilha = new Pilha(5);
        assert pilha.indexOf(10) == -1;
        pilha.push(10);
        assert pilha.indexOf(10) == 0;
        pilha.push(20);
        assert pilha.indexOf(20) == 1;
        assert pilha.indexOf(10) == 0;

        pilha.push(30);
        pilha.push(10);
        assert pilha.indexOf(10) == 3;
    }

    public void testPilhaLastIndexOf() {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);

        assert pilha.lastIndexOf(50) == 4;
        assert pilha.lastIndexOf(10) == 0;
        assert pilha.lastIndexOf(30) == 2;

        pilha.pop();
        pilha.push(30);
        assert pilha.lastIndexOf(30) == 4;
        assert pilha.indexOf(30) == 2;
    }

    public static void main(String[] args) {
        AssertsPilha testes = new AssertsPilha();
        testes.testPilhaPush();
        testes.testPilhaPop();
        testes.testPilhaToString();
        testes.testPilhaIndexOf();
        testes.testPilhaLastIndexOf();
        System.out.println("Todos os testes de AssertsPilha passaram.");
    }
}