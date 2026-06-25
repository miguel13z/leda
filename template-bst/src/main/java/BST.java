import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        return null;
    }
    
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return -1;
    }


    public boolean equals(BST outra) {
        return false;
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return -1;
    }

    

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
}
