import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(String valor) {
        Node newNode = new Node(valor);
        
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        
        size += 1;
    }

    public void addLast(String valor) {
        Node newNode = new Node(valor);
        
        if(isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        this.size += 1;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, String valor) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        
        Node newNode = new Node(valor);
        
        if (index == 0) {
            this.addFirst(valor);
        
        } else if (index == size) {
            this.addLast(valor);
        
        } else {
            Node aux = this.head;
            
            for (int i = 0; i < index - 1; i++)
                aux = aux.next;
            
            newNode.next = aux.next;
            aux.next = newNode;
            newNode.prev = aux;
            newNode.next.prev = newNode;
            
            size += 1;
        }
    }

    public String getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.value;
    }

    public String getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public String get(int index) {
         if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        Node aux = this.head;
        
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        return aux.value;
    }
    
    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        
        String v = this.head.value;
        
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        
        size -= 1;
        return v;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        
        String v = this.tail.value;
        
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }           
        
        size -= 1;
        return v;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public String remove(int index) {
         if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        
        Node aux = this.head;
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        size -= 1;
        return aux.value;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(String value) {
        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.value.equals(value)) {
                if (i == 0) removeFirst();
                else if (i == size - 1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size -= 1;
                }
                
                return true;
            }
            aux = aux.next;
        }
        
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(String value) {
        Node aux = this.head;
        int index = 0;
        while (aux != null) { 
            if(aux.value.equals(value))
                return index;
            aux = aux.next;
            index += 1;
        }
        
        return -1;
    }

    public boolean contain(String v) {
        return indexOf(v) != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(String valor) {
        if (isEmpty()) return -1;
        
        int last = -1;
        Node aux = this.head;
        int i = -1;
        while (aux != null) {
            i += 1;
            if (aux.value.equals(valor))
                last = i;
            aux = aux.next;
        }

        return last;
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
        return this.size;
    }

    public Node getNode(String value) { 
        Node aux = this.head;
        int i = 0;

        while(i < this.size && !value.equals(aux.value)) {
            aux = aux.next;
            i++;
        }

        return aux;
    }

    // deve ser O(n)
    public void sortByFrequency(Node node) {
        Node aux = node.next;

        while (aux != null && node.frequency > aux.frequency) {
            node.next = aux.next;
            aux.prev = node.prev;

            aux.next = node;
            node.prev = aux;
            
            if (node == this.head && aux == this.tail) {
                this.head = aux;
                this.tail = node;
                
            } else if (node == this.head) {
                node.next.prev = node;
                this.head = aux;

            } else if (aux == this.tail) {
                aux.prev.next = aux;
                this.tail = node;

            } else {

                node.next.prev = node;
                aux.prev.next = aux;
            }

            aux = node.next;
        }
    }
}

class Node {

    String value;
    int frequency;
    Node prev;
    Node next;

    Node(String v) {
        this.value = v;
        this.frequency = 1;
    }

}
