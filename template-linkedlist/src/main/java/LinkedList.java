import java.util.NoSuchElementException;

public class LinkedList {

    
    public LinkedList() {
    }
   
    public boolean isEmpty() {
        return false;
    }

    public void addFirst(int valor) {
    }

    public void addLast(int valor) {
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
    }

    public int getFirst() {
        return -1;
    }

    public int getLast() {
        return -1;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
         return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        return -1;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        return -1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        return -1;
    }

    public boolean contain(int v) {
        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return -1;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}