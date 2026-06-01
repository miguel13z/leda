public class ArrayList {

   
    public ArrayList(int capacidadeInicial) {
        // TODO
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public void addFirst(int valor) {
        // TODO
    }

    public void addLast(int valor) {
        // TODO
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        //TODO
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       // TODO 
    }

    public void assegureCapacidade(int capacidadePretendida) {
       // TODO
    }

    public int getFirst() {
        // TODO
        return -1;
    }

    public int getLast() {
        //TODO
        return -1;
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        // TODO
        return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        // TODO 
        return 0;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        //TODO
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        // TODO
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        // TODO
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        // TODO
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        return "";
    }
    
    public int size() {
        // TODO
        return 0;
    }
}
