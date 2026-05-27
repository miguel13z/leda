public class Pilha {

	private int[] pilha;
	private int topo;

    public Pilha(int capacidade) {
    	this.pilha = new int[capacidade];
    	this.topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull()) {
			throw new RuntimeException("Pilha já está cheia.");
		}
        pilha[++topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
    	if (isEmpty()) {
			throw new RuntimeException("Pilha já está vazia.");
		}
        return pilha[topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
    	if (isEmpty()) {
			throw new RuntimeException("Pilha já está vazia.");
		}
        return pilha[topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc.
    @Override
	public String toString() {
    	Pilha pilhaAuxiliar = new Pilha(pilha.length);
    	String out = "";
    	
    	while(!isEmpty()) {
    		int elemento = pop();
    		if (topo == -1) {
    			out += elemento;
    		}
    		else {
    			out += elemento + ", ";
    		}
    		pilhaAuxiliar.push(elemento);
    	}

    	while (!pilhaAuxiliar.isEmpty()) {
    		push(pilhaAuxiliar.pop());
    	}

        return out;
    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
    	Pilha pilhaAuxiliar = new Pilha(pilha.length);
    	int posElemento = -1;
    	int i = 0;
    	while(!isEmpty()) {
    		int elemento = pop();
    		if (elemento == valor) {
    			posElemento = i;
    			pilhaAuxiliar.push(elemento);
    			break;
    		}
    		pilhaAuxiliar.push(elemento);
    		i++;
    	}
    	
    	while(!pilhaAuxiliar.isEmpty()) {
    		push(pilhaAuxiliar.pop());
    	}
    	
    	return posElemento;
    }
    
    public int lastIndexOf(int valor) {
    	return size() - indexOf(valor);
    }

    public int size() {
        return topo + 1;
    }

}
