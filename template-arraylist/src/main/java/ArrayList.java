public class ArrayList {
	private int[] arrayList;
	private int tamanho;
   
    public ArrayList(int capacidadeInicial) {
        arrayList = new int[capacidadeInicial];
        tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
    
    private void shiftDireita(int posLiberada) {
    	for (int i = tamanho - 1; i >= posLiberada; i--) {
    		arrayList[i + 1] = arrayList[i];
    	}
    }

    public void addFirst(int valor) {
    	if (tamanho + 1 > arrayList.length) {
    		resize(arrayList.length * 2);
    	}
    	
    	shiftDireita(0);
    	arrayList[0] = valor;
    	tamanho++;
    }

    public void addLast(int valor) {
    	if (tamanho + 1 > arrayList.length) {
    		resize(arrayList.length * 2);
    	}
    	
        arrayList[tamanho] = valor;
        tamanho++;
    }


	// adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo.");
        }
        
        if (tamanho == arrayList.length) {
            resize(arrayList.length * 2);
        }
        
        shiftDireita(index);
        arrayList[index] = valor;
        tamanho++;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
    	int[] arrayMaior = new int[novaCapacidade];
    	for (int i = 0; i < tamanho; i++) {
    		arrayMaior[i] = arrayList[i];
    	}
    	arrayList = arrayMaior;
    }

    public void assegureCapacidade(int capacidadePretendida) {
       if (capacidadePretendida > arrayList.length) {
    	   resize(capacidadePretendida);
       }
    }

    public int getFirst() {
    	if (isEmpty()) throw new RuntimeException("ArrayList está vazio.");
        return arrayList[0];
    }

    public int getLast() {
    	if (isEmpty()) throw new RuntimeException("ArrayList está vazio.");
        return arrayList[tamanho - 1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Índice fora do intervalo.");
        return arrayList[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
    	if (isEmpty()) throw new RuntimeException("ArrayList está vazio.");
    	int elemento = arrayList[0];
    	shiftEsquerda(0);
    	tamanho--;
        return elemento;
    }

    private void shiftEsquerda(int pos) {
		for (int i = pos + 1; i < tamanho; i++) {
			arrayList[i - 1] = arrayList[i];
		}
	}

	// deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
    	if (isEmpty()) throw new RuntimeException("ArrayList está vazio.");
    	tamanho--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
    	if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException("Índice fora do intervalo.");
    	shiftEsquerda(index);
    	tamanho--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for (int i = 0; i < tamanho; i++) {
        	if (arrayList[i] == value) {
        		remove(i);
        		break;
        	}
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < tamanho; i++) {
        	if (arrayList[i] == value) {
        		return i;
        	}
        }
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
    	int index = -1;
    	for (int i = 0; i < tamanho; i++) {
        	if (arrayList[i] == valor) {
        		index = i;
        	}
        }
        return index;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
    	String out = "";
    	for (int i = 0; i < tamanho; i++) {
    		if (i + 1 == tamanho) {
    			out += arrayList[i];
    		}
    		else {
    			out += arrayList[i] + " ";
    		}
    	}
    	
        return out;
    }
    
    public int size() {
        return tamanho;
    }
}
